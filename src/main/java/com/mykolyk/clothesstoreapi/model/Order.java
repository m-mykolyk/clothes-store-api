package com.mykolyk.clothesstoreapi.model;

import com.mykolyk.clothesstoreapi.dto.OrderDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Order {
    private int id;

    private User user;

    private LocalDateTime createdAt;

    private String status;

    private List<OrderItem> items;
}
