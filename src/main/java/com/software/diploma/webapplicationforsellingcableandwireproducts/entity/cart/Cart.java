package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.cart;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.BaseEntity;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class Cart extends BaseEntity {
    @OneToOne
    @ToString.Exclude
    private User user;

    @Column(nullable = true)
    private LocalDateTime lastUpdatedAt;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart", orphanRemoval = true)
    private List<CartProduct> cartProducts;

    public Cart(User user) {
        this.user = user;
    }
}
