package com.mykolyk.clothesstoreapi.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItem {
    private int id;

    private Order order;

    private Product product;

    private int quantity;

    private BigDecimal totalPrice;
}
