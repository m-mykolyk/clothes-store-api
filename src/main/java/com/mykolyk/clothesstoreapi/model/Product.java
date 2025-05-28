package com.mykolyk.clothesstoreapi.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {
    private int id;

    private String name;

    private String description;

    private String category;

    private BigDecimal price;

    private String size;

    private int stock;
}
