package com.mykolyk.clothesstoreapi.service.impl;

import com.mykolyk.clothesstoreapi.dto.OrderDto;
import com.mykolyk.clothesstoreapi.dto.OrderItemDto;
import com.mykolyk.clothesstoreapi.dto.ProductDto;
import com.mykolyk.clothesstoreapi.dto.UserDto;
import com.mykolyk.clothesstoreapi.model.Order;
import com.mykolyk.clothesstoreapi.model.OrderItem;
import com.mykolyk.clothesstoreapi.model.Product;
import com.mykolyk.clothesstoreapi.model.User;
import com.mykolyk.clothesstoreapi.service.MappingService;
import org.springframework.stereotype.Service;

@Service
public class MappingServiceImpl implements MappingService {
    @Override
    public UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .repeatPassword(user.getPassword())
                .build();
    }

    @Override
    public User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }

    @Override
    public ProductDto mapProductToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .size(product.getSize())
                .stock(product.getStock())
                .build();
    }

    @Override
    public Product mapProductDtoToProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .category(productDto.getCategory())
                .price(productDto.getPrice())
                .size(productDto.getSize())
                .stock(productDto.getStock())
                .build();
    }

    @Override
    public OrderDto mapOrderToOrderDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .userDto(mapUserToUserDto(order.getUser()))
                .createdAt(order.getCreatedAt())
                .status(order.getStatus())
                .items(order.getItems().stream().map(this::mapOrderItemToOrderItemDto).toList())
                .build();
    }

    @Override
    public Order mapOrderDtoToOrder(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .user(mapUserDtoToUser(orderDto.getUserDto()))
                .createdAt(orderDto.getCreatedAt())
                .status(orderDto.getStatus())
                .items(orderDto.getItems().stream().map(this::mapOrderItemDtoToOrderItem).toList())
                .build();
    }

    @Override
    public OrderItemDto mapOrderItemToOrderItemDto(OrderItem orderItem) {
        return OrderItemDto.builder()
                .id(orderItem.getId())
                .order(mapOrderToOrderDto(orderItem.getOrder()))
                .product(mapProductToProductDto(orderItem.getProduct()))
                .quantity(orderItem.getQuantity())
                .totalPrice(orderItem.getTotalPrice())
                .build();
    }

    @Override
    public OrderItem mapOrderItemDtoToOrderItem(OrderItemDto orderItemDto) {
        return OrderItem.builder()
                .id(orderItemDto.getId())
                .order(mapOrderDtoToOrder(orderItemDto.getOrder()))
                .product(mapProductDtoToProduct(orderItemDto.getProduct()))
                .quantity(orderItemDto.getQuantity())
                .totalPrice(orderItemDto.getTotalPrice())
                .build();
    }
}
