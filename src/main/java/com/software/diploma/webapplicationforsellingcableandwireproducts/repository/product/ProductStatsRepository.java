package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.ProductStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductStatsRepository extends JpaRepository<ProductStats, Long> {
    @Query("SELECT ps FROM ProductStats ps WHERE ps.product.id = :productId AND ps.product.isDeleted = false")
    Optional<ProductStats> findByProductIdAndProductNotDeleted(long productId);

    //@Query("SELECT ps FROM ProductStats ps WHERE ps.product.id = :productId AND ps.product.isDeleted = false")
    Optional<ProductStats> findByProductId(long productId);
}
