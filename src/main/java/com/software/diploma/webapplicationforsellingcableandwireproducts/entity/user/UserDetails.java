package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_details")
public class UserDetails extends BaseEntity {
    @OneToOne
    private User user;

    @Column(nullable = false)
    private String avatarUrl;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal redemptionSum = BigDecimal.ZERO;

    public UserDetails(User user) {
        this.user = user;
    }
}
