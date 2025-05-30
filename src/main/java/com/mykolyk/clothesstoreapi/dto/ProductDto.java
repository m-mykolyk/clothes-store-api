package com.mykolyk.clothesstoreapi.dto;

import com.mykolyk.clothesstoreapi.dto.group.OnCreate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {
    private int id;

    @NotBlank(message = "'name' shouldn't be empty", groups = OnCreate.class)
    private String name;

    private String description;

    @NotBlank(message = "'name' shouldn't be empty", groups = OnCreate.class)
    private String category;

    @NotNull(message = "'price' shouldn't be Null", groups = OnCreate.class)
    private BigDecimal price;

    private String size;

    private int stock;
}
