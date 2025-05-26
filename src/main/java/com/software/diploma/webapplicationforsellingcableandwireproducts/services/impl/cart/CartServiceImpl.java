package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.cart;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.Cart;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.cart.CartNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.user.UserNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.cart.CartRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.cart.CartExceptionMessage.CART_NOT_FOUND_MESSAGE;
import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.cart.CartExceptionMessage.CART_PRODUCT_NOT_FOUND_MESSAGE;
import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.user.UserExceptionMessage.USER_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository repository;

    @Transactional(readOnly = true)
    public Cart getByUserId(Long userId) {
        return repository.findByUserIdAndUserNotDeleted(userId)
                .orElseThrow(() -> {
                    throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE);
                });
    }

    @Transactional(readOnly = true)
    public Cart getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    throw new CartNotFoundException(CART_NOT_FOUND_MESSAGE);
                });
    }

    @Transactional
    public Cart save(Cart cart) {
        return repository.save(cart);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Cart updateLastUpdatedAt(Long id) {
        Cart cartFromDb = repository.findById(id)
                .orElseThrow(() -> {
                    throw new UserNotFoundException(CART_PRODUCT_NOT_FOUND_MESSAGE);
                });

        cartFromDb.setLastUpdatedAt(LocalDateTime.now());

        return repository.save(cartFromDb);
    }
}
