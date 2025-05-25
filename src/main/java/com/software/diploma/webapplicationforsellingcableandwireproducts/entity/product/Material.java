package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "material")
public class Material extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne//(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_details_id")
    @JsonBackReference
    private ProductDetails productDetails;
}
