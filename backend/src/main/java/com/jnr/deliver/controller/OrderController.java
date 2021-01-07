package com.jnr.deliver.controller;

import com.jnr.deliver.dto.OrderDTO;
import com.jnr.deliver.dto.ProductDTO;
import com.jnr.deliver.service.OrderService;
import com.jnr.deliver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> orderDTOList = orderService.findAll();
        return ResponseEntity.ok().body(orderDTOList);
    }

}
