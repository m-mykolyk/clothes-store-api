package com.mykolyk.clothesstoreapi.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderDto {
    private int id;
    private UserDto userDto;
    private LocalDateTime createdAt;
    private String status;
    private List<OrderItemDto> items;
}
