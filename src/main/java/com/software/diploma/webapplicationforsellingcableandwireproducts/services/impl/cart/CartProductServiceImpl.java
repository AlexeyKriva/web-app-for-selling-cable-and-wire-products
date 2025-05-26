package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.cart.CartProductSaveDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.cart.CartTotalProductAmountDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import com.software.diploma.webapplicationforsellingcableandwireproducts.event.cart.CartEventStatus;
import com.software.diploma.webapplicationforsellingcableandwireproducts.event.cart.CartUpdateEvent;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.InsufficientStockException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.cart.CartProductNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.cart.CartProductMapper;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.cart.CartProductRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.cart.CartProductService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.cart.CartService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.GlobalConstants.*;
import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.cart.CartExceptionMessage.CART_PRODUCT_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class CartProductServiceImpl implements CartProductService {
    private final CartProductRepository repository;
    private final ApplicationEventPublisher publisher;
    private final ProductStatsService productStatsService;
    private final CartProductMapper mapper = CartProductMapper.INSTANCE;
    private final CartService cartService;
    private final ProductService productService;

    @Transactional(readOnly = true)
    public List<CartProduct> getAllByCartId(Long cartId, Pageable pageable) {
        return repository.findAllByCartId(cartId, pageable);
    }

    @Transactional
    public CartProduct save(CartProductSaveDto cartProductSaveDto) {
        CartProduct cartProduct = mapper.toCartProduct(cartProductSaveDto);
        cartProduct.setCart(cartService.getById(cartProductSaveDto.cartId()));
        cartProduct.setProduct(productService.getById(cartProductSaveDto.productId()));

        Integer stockQuantity = productStatsService.getStockQuantityByProductId(cartProduct.getProduct().getId());

        if (cartProduct.getTotalProductAmount() <= stockQuantity) {
            CartProduct cartProductFromDb = repository.save(cartProduct);

            publisher.publishEvent(new CartUpdateEvent(this, cartProductFromDb,
                    cartProductFromDb.getTotalProductAmount(), CartEventStatus.ADD_PRODUCTS));

            return cartProductFromDb;
        }

        throw new InsufficientStockException(INSUFFICIENT_STOCK_MESSAGE, cartProduct.getTotalProductAmount(),
                stockQuantity);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteById(Long id) {
        CartProduct cartProductFromDb = repository.findById(id)
                .orElseThrow(() -> new CartProductNotFoundException(CART_PRODUCT_NOT_FOUND_MESSAGE));

        publisher.publishEvent(new CartUpdateEvent(this, cartProductFromDb,
                cartProductFromDb.getTotalProductAmount(), CartEventStatus.DELETE_PRODUCTS));

        repository.deleteById(id);
    }

    @Transactional
    public CartProduct updateTotalProductAmountById(Long id, CartTotalProductAmountDto cartTotalProductAmountDto) {
        CartProduct cartProductFromDb = repository.findById(id)
                .orElseThrow(() -> new CartProductNotFoundException(CART_PRODUCT_NOT_FOUND_MESSAGE));

        int deltaTotalProductAmount = cartTotalProductAmountDto.deltaTotalProductAmount();

        Integer stockQuantity = productStatsService.getStockQuantityByProductId(cartProductFromDb.getProduct().getId());

        if (cartProductFromDb.getTotalProductAmount() + deltaTotalProductAmount <= stockQuantity) {
            int newTotalProductAmount = totalProductAmount(cartProductFromDb.getTotalProductAmount(),
                    deltaTotalProductAmount);

            publisher.publishEvent(new CartUpdateEvent(this, cartProductFromDb, deltaTotalProductAmount < 0 ?
                            Math.max(deltaTotalProductAmount,
                                    DEFAULT_NEGATIVE * cartProductFromDb.getTotalProductAmount()) :
                            deltaTotalProductAmount, CartEventStatus.UPDATE_PRODUCTS));

            if (cartProductFromDb.getTotalProductAmount() + deltaTotalProductAmount <= MIN_TOTAL_PRODUCT_AMOUNT_IN_CART) {

                repository.deleteById(id);

                return null;
            }

            cartProductFromDb.setTotalProductAmount(newTotalProductAmount);

            return repository.save(cartProductFromDb);
        }

        throw new InsufficientStockException(INSUFFICIENT_STOCK_MESSAGE, cartProductFromDb.getTotalProductAmount(),
                stockQuantity);
    }

    private Integer totalProductAmount(Integer currentTotalProductAmount, Integer deltaTotalProductAmount) {
        Integer updatedTotalProductAmount =  currentTotalProductAmount + deltaTotalProductAmount;

        return updatedTotalProductAmount >= MIN_TOTAL_PRODUCT_AMOUNT_IN_CART ?
                updatedTotalProductAmount : MIN_TOTAL_PRODUCT_AMOUNT_IN_CART;
    }
}
