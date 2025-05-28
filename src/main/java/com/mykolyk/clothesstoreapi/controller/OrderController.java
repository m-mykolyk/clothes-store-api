package com.mykolyk.clothesstoreapi.controller;

import com.mykolyk.clothesstoreapi.controller.assembler.OrderAssembler;
import com.mykolyk.clothesstoreapi.controller.model.OrderModel;
import com.mykolyk.clothesstoreapi.dto.OrderDto;
import com.mykolyk.clothesstoreapi.dto.group.OnCreate;
import com.mykolyk.clothesstoreapi.dto.group.OnUpdate;
import com.mykolyk.clothesstoreapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderAssembler orderAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/orders/{id}")
    public OrderModel getOrder(@PathVariable int id) {
        OrderDto outOrderDto = orderService.getOrder(id);
        return orderAssembler.toModel(outOrderDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/orders")
    public OrderModel createOrder(@RequestBody @Validated(OnCreate.class) OrderDto OrderDto) {
        OrderDto outOrderDto = orderService.createOrder(OrderDto);
        return orderAssembler.toModel(outOrderDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/orders/{id}")
    public OrderModel updateOrder(@PathVariable int id, @Validated(OnUpdate.class) @RequestBody OrderDto OrderDto) {
        OrderDto outOrderDto = orderService.updateOrder(id, OrderDto);
        return orderAssembler.toModel(outOrderDto);
    }

    @DeleteMapping(value = "Orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
