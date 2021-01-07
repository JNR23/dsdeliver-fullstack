package com.jnr.deliver.repository;

import com.jnr.deliver.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
