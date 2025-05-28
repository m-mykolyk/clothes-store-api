package com.mykolyk.clothesstoreapi.service;

import com.mykolyk.clothesstoreapi.dto.ProductDto;

public interface ProductService {
    ProductDto getProduct(int id);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(int id, ProductDto productDto);

    void deleteProduct(int id);
}
