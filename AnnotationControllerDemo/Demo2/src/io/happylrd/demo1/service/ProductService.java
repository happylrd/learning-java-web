package io.happylrd.demo1.service;

import io.happylrd.demo1.model.Product;

public interface ProductService {
    Product add(Product product);

    Product get(long id);
}
