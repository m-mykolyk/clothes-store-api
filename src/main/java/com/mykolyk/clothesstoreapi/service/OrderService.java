package com.mykolyk.clothesstoreapi.service;

import com.mykolyk.clothesstoreapi.dto.OrderDto;

public interface OrderService {
    OrderDto getOrder(int id);

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(int id, OrderDto orderDto);

    void deleteOrder(int id);
}
