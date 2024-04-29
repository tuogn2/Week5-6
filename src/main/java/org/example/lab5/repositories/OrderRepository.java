package org.example.lab5.repositories;

import org.example.lab5.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderProduct, String> {
}