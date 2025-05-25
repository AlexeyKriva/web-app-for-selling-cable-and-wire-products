package com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.GlobalConstants.DEFAULT_INTEGER_VALUE;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_details")
public class ProductDetails extends BaseEntity {
    @OneToOne
    private Product product;

    @OneToOne
    private Category category;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String anufacturer;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productDetails", orphanRemoval = true)
    private List<Material> materials = new ArrayList<>();

    public ProductDetails(Product product) {
        this.product = product;
    }
}
