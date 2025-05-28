package com.mykolyk.clothesstoreapi.service;

import com.mykolyk.clothesstoreapi.dto.OrderDto;
import com.mykolyk.clothesstoreapi.dto.OrderItemDto;
import com.mykolyk.clothesstoreapi.dto.ProductDto;
import com.mykolyk.clothesstoreapi.dto.UserDto;
import com.mykolyk.clothesstoreapi.model.Order;
import com.mykolyk.clothesstoreapi.model.OrderItem;
import com.mykolyk.clothesstoreapi.model.Product;
import com.mykolyk.clothesstoreapi.model.User;

public interface MappingService {
    UserDto mapUserToUserDto(User user);

    User mapUserDtoToUser(UserDto userDto);

    ProductDto mapProductToProductDto(Product product);

    Product mapProductDtoToProduct(ProductDto productDto);

    OrderDto mapOrderToOrderDto(Order order);

    Order mapOrderDtoToOrder(OrderDto orderDto);

    OrderItemDto mapOrderItemToOrderItemDto(OrderItem orderItem);

    OrderItem mapOrderItemDtoToOrderItem(OrderItemDto orderItemDto);
}
