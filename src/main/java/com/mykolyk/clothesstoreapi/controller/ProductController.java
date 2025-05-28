package com.mykolyk.clothesstoreapi.controller;

import com.mykolyk.clothesstoreapi.controller.assembler.ProductAssembler;
import com.mykolyk.clothesstoreapi.controller.model.ProductModel;
import com.mykolyk.clothesstoreapi.dto.ProductDto;
import com.mykolyk.clothesstoreapi.dto.group.OnCreate;
import com.mykolyk.clothesstoreapi.dto.group.OnUpdate;
import com.mykolyk.clothesstoreapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductAssembler productAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/products/{id}")
    public ProductModel getProduct(@PathVariable int id) {
        ProductDto outProductDto = productService.getProduct(id);
        return productAssembler.toModel(outProductDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/products")
    public ProductModel createProduct(@RequestBody @Validated(OnCreate.class) ProductDto productDto) {
        ProductDto outProductDto = productService.createProduct(productDto);
        return productAssembler.toModel(outProductDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/products/{id}")
    public ProductModel updateProduct(@PathVariable int id, @Validated(OnUpdate.class) @RequestBody ProductDto productDto) {
        ProductDto outProductDto = productService.updateProduct(id, productDto);
        return productAssembler.toModel(outProductDto);
    }

    @DeleteMapping(value = "products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
