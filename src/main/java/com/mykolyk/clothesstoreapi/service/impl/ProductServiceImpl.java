package com.mykolyk.clothesstoreapi.service.impl;

import com.mykolyk.clothesstoreapi.dto.ProductDto;
import com.mykolyk.clothesstoreapi.model.Product;
import com.mykolyk.clothesstoreapi.repository.ProductRepository;
import com.mykolyk.clothesstoreapi.service.MappingService;
import com.mykolyk.clothesstoreapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final MappingService mappingService;

    @Override
    public ProductDto getProduct(int id) {
        log.info("getProduct by id {}", id);
        return mappingService.mapProductToProductDto(productRepository.getProduct(id));
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        log.info("createProduct with id {}", productDto.getId());
        return mappingService.mapProductToProductDto(productRepository.createProduct(mappingService.mapProductDtoToProduct(productDto)));
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        log.info("updateProduct with id {}", id);
        Product product = mappingService.mapProductDtoToProduct(productDto);

        Product oldProduct = productRepository.getProduct(id);
        product.setId(oldProduct.getId());

        product = productRepository.updateProduct(id, product);
        return mappingService.mapProductToProductDto(product);
    }

    @Override
    public void deleteProduct(int id) {
        log.info("deleteProduct with id {}", id);
        productRepository.deleteProduct(id);
    }
}
