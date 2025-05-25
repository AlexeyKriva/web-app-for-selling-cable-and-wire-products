package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.product;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.product.Product;
import com.software.diploma.webapplicationforsellingcableandwireproducts.event.product.SaveProductEvent;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.product.ProductNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.product.ProductRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.product.ProductExceptionMessage.PRODUCT_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ApplicationEventPublisher publisher;

    @Transactional(readOnly = true)
    public Product getById(long id) {
        return repository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> {
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND_MESSAGE);
        });
    }

    @Transactional(readOnly = true)
    public Page<Product> getAll(Pageable pageable) {
        return repository.findByIsDeletedFalse(pageable);
    }

    @Transactional
    public Product save(Product product) {
        Product productFromDb = repository.save(product);

        publisher.publishEvent(new SaveProductEvent(this, productFromDb));

        return productFromDb;
    }

    @Transactional
    public void deleteById(long id) {
        Product product = repository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> {
                    throw new ProductNotFoundException(PRODUCT_NOT_FOUND_MESSAGE);
                });

        product.setDeleted(true);

        repository.save(product);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
