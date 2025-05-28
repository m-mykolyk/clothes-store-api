package com.mykolyk.clothesstoreapi.controller.assembler;

import com.mykolyk.clothesstoreapi.controller.ProductController;
import com.mykolyk.clothesstoreapi.controller.model.ProductModel;
import com.mykolyk.clothesstoreapi.dto.ProductDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductAssembler extends RepresentationModelAssemblerSupport<ProductDto, ProductModel> {
    public static final String GET_REL = "get_product";
    public static final String CREATE_REL = "create_product";
    public static final String UPDATE_PRODUCT = "update_product";
    public static final String DELETE_PRODUCT = "delete_product";

    public ProductAssembler() {
        super(ProductController.class, ProductModel.class);
    }

    @Override
    public ProductModel toModel(ProductDto entity) {
        ProductModel ProductModel = new ProductModel(entity);

        Link get = linkTo(methodOn(ProductController.class).getProduct(entity.getId())).withRel(GET_REL);
        Link create = linkTo(methodOn(ProductController.class).createProduct(entity)).withRel(CREATE_REL);
        Link update = linkTo(methodOn(ProductController.class).updateProduct(entity.getId(), entity)).withRel(UPDATE_PRODUCT);
        Link delete = linkTo(methodOn(ProductController.class).deleteProduct(entity.getId())).withRel(DELETE_PRODUCT);

        ProductModel.add(get, create, update, delete);

        return ProductModel;
    }
}
