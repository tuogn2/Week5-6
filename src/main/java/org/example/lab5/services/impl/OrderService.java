package org.example.lab5.services.impl;

import org.example.lab5.models.OrderProduct;
import org.example.lab5.repositories.OrderRepository;
import org.example.lab5.services.Iservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements Iservices<OrderProduct,Long> {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean save(OrderProduct entity) {
       try {
           return orderRepository.save(entity) != null;
       }catch (Exception e){
           return false;
       }
    }

    @Override
    public boolean delete(Long id) {
       try {
           orderRepository.deleteById(String.valueOf(id));
           return true;
       }catch (Exception e){
           return false;
       }
    }

    @Override
    public boolean update(OrderProduct entity) {
        try {
            return orderRepository.save(entity) != null;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public OrderProduct findById(Long id) {
        try {
            return orderRepository.findById(String.valueOf(id)).orElse(null);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<OrderProduct> findAll() {
        try {
            return orderRepository.findAll();
        }catch (Exception e){
            return null;
        }
    }



}
