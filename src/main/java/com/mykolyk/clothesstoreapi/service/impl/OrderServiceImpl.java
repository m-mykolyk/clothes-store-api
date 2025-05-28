package com.mykolyk.clothesstoreapi.service.impl;

import com.mykolyk.clothesstoreapi.dto.OrderDto;
import com.mykolyk.clothesstoreapi.model.Order;
import com.mykolyk.clothesstoreapi.repository.OrderRepository;
import com.mykolyk.clothesstoreapi.service.MappingService;
import com.mykolyk.clothesstoreapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final MappingService mappingService;

    @Override
    public OrderDto getOrder(int id) {
        log.info("getProduct by id {}", id);
        return mappingService.mapOrderToOrderDto(orderRepository.getOrder(id));
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        log.info("createOrder with id {}", orderDto.getId());
        return mappingService.mapOrderToOrderDto(orderRepository.createOrder(mappingService.mapOrderDtoToOrder(orderDto)));
    }

    @Override
    public OrderDto updateOrder(int id, OrderDto orderDto) {
        log.info("updateOrder with id {}", id);
        Order order = mappingService.mapOrderDtoToOrder(orderDto);

        Order oldOrder = orderRepository.getOrder(id);
        order.setId(oldOrder.getId());

        order = orderRepository.updateOrder(id, order);
        return mappingService.mapOrderToOrderDto(order);
    }

    @Override
    public void deleteOrder(int id) {
        log.info("deleteOrder with id {}", id);
        orderRepository.deleteOrder(id);
    }
}
