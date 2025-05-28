package com.mykolyk.clothesstoreapi.repository;

import com.mykolyk.clothesstoreapi.model.Order;

public interface OrderRepository {
    Order getOrder(int id);

    Order createOrder(Order order);

    Order updateOrder(int id, Order order);

    void deleteOrder(int id);
}
