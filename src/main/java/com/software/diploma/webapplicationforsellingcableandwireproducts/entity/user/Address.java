package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address extends BaseEntity {
    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String houseNumber;

    @Column(nullable = false)
    private String apartmentNumber;

    @Column(nullable = false)
    private String zipCode;
}
