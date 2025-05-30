package com.mykolyk.clothesstoreapi.dto;

import com.mykolyk.clothesstoreapi.dto.group.OnCreate;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderDto {
    private int id;

    @NotNull(message = "'userDto' shouldn't be Null", groups = OnCreate.class)
    private UserDto userDto;

    private LocalDateTime createdAt;

    private String status;

    private List<OrderItemDto> items;
}
