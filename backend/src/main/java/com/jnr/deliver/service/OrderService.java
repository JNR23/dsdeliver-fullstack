package com.jnr.deliver.service;

import com.jnr.deliver.dto.OrderDTO;
import com.jnr.deliver.dto.ProductDTO;
import com.jnr.deliver.model.Order;
import com.jnr.deliver.model.OrderStatus;
import com.jnr.deliver.model.Product;
import com.jnr.deliver.repository.OrderRepository;
import com.jnr.deliver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> orderList = orderRepository.findOrderWithProducts();
        return orderList.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(),
                dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
        for (ProductDTO p : dto.getProductDTOList()) {
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }

}
