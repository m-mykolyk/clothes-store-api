package com.mykolyk.clothesstoreapi.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItemDto {
    private int id;
    private OrderDto order;
    private ProductDto product;
    private int quantity;
    private BigDecimal totalPrice;
}
