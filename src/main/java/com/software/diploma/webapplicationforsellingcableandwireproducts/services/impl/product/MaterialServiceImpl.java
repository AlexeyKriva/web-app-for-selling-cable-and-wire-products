package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Material;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product.MaterialNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.product.MaterialRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.product.ProductExceptionMessage.MATERIAL_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository repository;

    @Transactional(readOnly = true)
    public List<Material> getAllByProductDetailsId(Long productDetailsId) {
        return repository.findAllByProductDetailsId(productDetailsId);
    }

    @Transactional
    public Material save(Material material) {
        return repository.save(material);
    }

    @Transactional
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return;
        }

        throw new MaterialNotFoundException(MATERIAL_NOT_FOUND_MESSAGE);
    }
}
