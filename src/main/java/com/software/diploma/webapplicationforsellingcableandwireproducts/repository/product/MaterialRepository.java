package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findAllByProductDetailsId(Long productDetailsId);
}
