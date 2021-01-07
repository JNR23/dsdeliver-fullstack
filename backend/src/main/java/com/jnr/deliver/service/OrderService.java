package com.jnr.deliver.service;

import com.jnr.deliver.dto.OrderDTO;
import com.jnr.deliver.dto.ProductDTO;
import com.jnr.deliver.model.Order;
import com.jnr.deliver.model.Product;
import com.jnr.deliver.repository.OrderRepository;
import com.jnr.deliver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> orderList = orderRepository.findOrderWithProducts();
        return orderList.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

}
