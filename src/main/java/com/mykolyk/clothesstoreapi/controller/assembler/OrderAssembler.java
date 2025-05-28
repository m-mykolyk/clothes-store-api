package com.mykolyk.clothesstoreapi.controller.assembler;

import com.mykolyk.clothesstoreapi.controller.OrderController;
import com.mykolyk.clothesstoreapi.controller.model.OrderModel;
import com.mykolyk.clothesstoreapi.dto.OrderDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderAssembler extends RepresentationModelAssemblerSupport<OrderDto, OrderModel> {
    public static final String GET_REL = "get_product";
    public static final String CREATE_REL = "create_product";
    public static final String UPDATE_PRODUCT = "update_product";
    public static final String DELETE_PRODUCT = "delete_product";

    public OrderAssembler() {
        super(OrderController.class, OrderModel.class);
    }

    @Override
    public OrderModel toModel(OrderDto entity) {
        OrderModel orderModel = new OrderModel(entity);

        Link get = linkTo(methodOn(OrderController.class).getOrder(entity.getId())).withRel(GET_REL);
        Link create = linkTo(methodOn(OrderController.class).createOrder(entity)).withRel(CREATE_REL);
        Link update = linkTo(methodOn(OrderController.class).updateOrder(entity.getId(), entity)).withRel(UPDATE_PRODUCT);
        Link delete = linkTo(methodOn(OrderController.class).deleteOrder(entity.getId())).withRel(DELETE_PRODUCT);

        orderModel.add(get, create, update, delete);

        return orderModel;
    }
}
