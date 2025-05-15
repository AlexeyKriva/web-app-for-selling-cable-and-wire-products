package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.GlobalConstants.DEFAULT_INTEGER_VALUE;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_stats")
public class UserStats extends BaseEntity {
    @OneToOne
    private User user;

    @Column(nullable = false)
    private int numberOfOrdersPurchased;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastVisit;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastPurchase;

    @PrePersist
    public void onCreate() {
        lastVisit = LocalDateTime.now();
    }

    public UserStats(User user) {
        this.user = user;
    }
}
