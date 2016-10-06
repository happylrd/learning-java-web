package io.happylrd.demo1.service;

import io.happylrd.demo1.model.Product;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductServiceImpl implements ProductService {

    private Map<Long, Product> productMap = new HashMap<>();
    private AtomicLong generator = new AtomicLong();

    public ProductServiceImpl() {
        Product product = new Product();
        product.setName("Fairy");
        product.setDescription("A beautiful fairy");
        product.setPrice(233.66F);
        add(product);
    }

    @Override
    public Product add(Product product) {
        long newId = generator.incrementAndGet();
        product.setId(newId);
        productMap.put(newId, product);
        return product;
    }

    @Override
    public Product get(long id) {
        return productMap.get(id);
    }
}
