package com.mykolyk.clothesstoreapi.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.mykolyk.clothesstoreapi.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderModel extends RepresentationModel<OrderModel> {
    @JsonUnwrapped
    private OrderDto orderDto;
}
