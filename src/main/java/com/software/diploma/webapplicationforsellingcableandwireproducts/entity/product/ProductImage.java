package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_image")
public class ProductImage extends BaseEntity {
    @Column(nullable = false)
    private long productId;

    @Column(nullable = false)
    private String url;
}
