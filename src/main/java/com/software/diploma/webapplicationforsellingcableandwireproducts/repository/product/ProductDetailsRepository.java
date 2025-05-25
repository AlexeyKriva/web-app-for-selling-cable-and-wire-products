package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
    @Query("SELECT pd FROM ProductDetails pd WHERE pd.product.id = :productId AND pd.product.isDeleted = false")
    Optional<ProductDetails> findByProductIdAndProductNotDeleted(long productId);
}
