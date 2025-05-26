package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.order;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.order.OrderSaveDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.order.OrderUpdateStatusDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart.CartProduct;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order.Order;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order.OrderProduct;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.order.OrderStatus;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Product;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;
import com.software.diploma.webapplicationforsellingcableandwireproducts.event.order.OrderPaidEvent;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.order.OrderAlreadyPaidException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.order.OrderNotFoundMessage;
import com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.order.OrderProductMapper;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.order.OrderRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.cart.CartService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.order.OrderService;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.GlobalConstants.*;
import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.order.OrderExceptionMessage.ORDER_ALREADY_PAID_MESSAGE;
import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.order.OrderExceptionMessage.ORDER_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final UserService userService;
    private final CartService cartService;
    private final OrderProductMapper orderProductMapper = OrderProductMapper.INSTANCE;
    private final ApplicationEventPublisher publisher;

    @Transactional(readOnly = true)
    public List<Order> getAllByUserId(Long userId) {
        return repository.findByProductIdAndProductNotDeleted(userId);
    }

    @Transactional
    public Order save(OrderSaveDto orderSaveDto) {
        User buyer = userService.getByIdAndNotDeleted(orderSaveDto.userId());
        List<CartProduct> cartProducts = cartService.getByUserId(buyer.getId()).getCartProducts();

        Order newOrder = Order.builder()
                .user(buyer)
                .totalSumInBelRub(totalSumInBelRub(cartProducts))
                .deliveryAddress(orderSaveDto.deliveryAddress())
                .createdDate(LocalDateTime.now())
                .status(OrderStatus.NEW)
                .build();

        List<OrderProduct> orderProducts = orderProductMapper.toOrderProducts(cartProducts);

        newOrder.setOrderProducts(orderProducts);
        orderProducts.forEach(orderProduct -> {
            orderProduct.setOrder(newOrder);
        });

        return repository.save(newOrder);
    }

    @Transactional
    public Order updateStatusById(Long id, OrderUpdateStatusDto orderUpdateStatusDto) {
        Order orderFromDb = repository.findById(id)
                .orElseThrow(() -> {
                    throw new OrderNotFoundMessage(ORDER_NOT_FOUND_MESSAGE);
                });

        if (!orderFromDb.getStatus().equals(OrderStatus.PAID)) {

            OrderStatus status = orderUpdateStatusDto.status();

            orderFromDb.setStatus(status);

            if (status.equals(OrderStatus.PAID)) {
                orderFromDb.setPaymentDate(LocalDateTime.now());
                publisher.publishEvent(new OrderPaidEvent(this, orderFromDb.getUser().getId(),
                        orderProductMapper.toCartProducts(orderFromDb.getOrderProducts())));
            }

            return repository.save(orderFromDb);
        }

        throw new OrderAlreadyPaidException(ORDER_ALREADY_PAID_MESSAGE);
    }

    private BigDecimal totalSumInBelRub(List<CartProduct> cartProducts) {
        double totalSumInBelRubNumber = DEFAULT_DOUBLE_VALUE;

        for (CartProduct cartProduct: cartProducts) {
            Product product = cartProduct.getProduct();

            double discount = DEFAULT_DISCOUNT_NUMBER;

            if (product.getDiscountPercentage() != null) {
                discount = (double) (ONE_HUNDRED_PERCENT - product.getDiscountPercentage()) / (double) ONE_HUNDRED_PERCENT;
            }

            totalSumInBelRubNumber += product.getPriceBelRub().doubleValue() * discount
                    * cartProduct.getTotalProductAmount();
        }

        return new BigDecimal(totalSumInBelRubNumber);
    }
}
