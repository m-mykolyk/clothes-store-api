package com.mykolyk.clothesstoreapi.dto;

import com.mykolyk.clothesstoreapi.dto.group.OnCreate;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItemDto {
    private int id;

    @NotNull(message = "'order' shouldn't be Null", groups = OnCreate.class)
    private OrderDto order;

    @NotNull(message = "'product' shouldn't be Null", groups = OnCreate.class)
    private ProductDto product;

    private int quantity;

    private BigDecimal totalPrice;
}
