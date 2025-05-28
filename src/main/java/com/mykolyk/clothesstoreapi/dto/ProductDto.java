package com.mykolyk.clothesstoreapi.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {
    private int id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private String size;
    private int stock;
}
