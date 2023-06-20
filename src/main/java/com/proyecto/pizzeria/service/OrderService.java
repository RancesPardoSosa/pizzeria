package com.proyecto.pizzeria.service;

import com.proyecto.pizzeria.persitence.entity.OrderEntity;
import com.proyecto.pizzeria.persitence.repository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    private final OrderRespository orderRespository;

    @Autowired
    public OrderService(OrderRespository orderRespository) {
        this.orderRespository = orderRespository;
    }

    public List<OrderEntity> getAll(){
        return this.orderRespository.findAll();
    }

    public List<OrderEntity> getTodayOrders(){
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return this.orderRespository.findAllByDateAfter(today);
    }

    public List<OrderEntity> getOutsideOrders(){
        List<Character> methods = Arrays.asList('D','C');
        return this.orderRespository.findAllByMethodIn(methods);
    }
}
