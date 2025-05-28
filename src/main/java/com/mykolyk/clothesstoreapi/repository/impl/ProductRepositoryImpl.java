package com.mykolyk.clothesstoreapi.repository.impl;

import com.mykolyk.clothesstoreapi.exception.ProductNotFoundException;
import com.mykolyk.clothesstoreapi.exception.UserNotFoundException;
import com.mykolyk.clothesstoreapi.model.Product;
import com.mykolyk.clothesstoreapi.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @Override
    public Product getProduct(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product createProduct(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        boolean isDeleted = products.removeIf(p -> p.getId() == id);
        if(isDeleted) {
            products.add(product);
        } else {
            throw new UserNotFoundException();
        }
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
