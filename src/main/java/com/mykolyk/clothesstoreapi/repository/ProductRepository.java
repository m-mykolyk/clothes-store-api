package com.mykolyk.clothesstoreapi.repository;

import com.mykolyk.clothesstoreapi.model.Product;

public interface ProductRepository {
    Product getProduct(int id);

    Product createProduct(Product product);

    Product updateProduct(int id, Product product);

    void deleteProduct(int id);
}
