package com.mykolyk.clothesstoreapi.service.impl;

import com.mykolyk.clothesstoreapi.dto.ProductDto;
import com.mykolyk.clothesstoreapi.model.Product;
import com.mykolyk.clothesstoreapi.repository.ProductRepository;
import com.mykolyk.clothesstoreapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductDto getProduct(int id) {
        log.info("getProduct by id {}", id);
        return mapProductToProductDto(productRepository.getProduct(id));
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        log.info("createProduct with id {}", productDto.getId());
        return mapProductToProductDto(productRepository.createProduct(mapProductDtoToProduct(productDto)));
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        log.info("updateProduct with id {}", id);
        Product product = mapProductDtoToProduct(productDto);

        Product oldProduct = productRepository.getProduct(id);
        product.setId(oldProduct.getId());

        product = productRepository.updateProduct(id, product);
        return mapProductToProductDto(product);
    }

    @Override
    public void deleteProduct(int id) {
        log.info("deleteProduct with id {}", id);
        productRepository.deleteProduct(id);
    }

    private ProductDto mapProductToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .size(product.getSize())
                .stock(product.getStock())
                .build();
    }

    private Product mapProductDtoToProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .category(productDto.getCategory())
                .price(productDto.getPrice())
                .size(productDto.getSize())
                .stock(productDto.getStock())
                .build();
    }
}
