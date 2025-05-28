package com.mykolyk.clothesstoreapi.repository.impl;

import com.mykolyk.clothesstoreapi.model.Order;
import com.mykolyk.clothesstoreapi.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public Order getOrder(int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElseThrow(); //TODO Create a custom exception
    }

    @Override
    public Order createOrder(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Order updateOrder(int id, Order order) {
        boolean isDeleted = orders.removeIf(o -> o.getId() == id);
        if(isDeleted) {
            orders.add(order);
        } else {
            throw new RuntimeException(); //TODO Crate a custom exception
        }
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        orders.removeIf(order -> order.getId() == id);
    }
}
