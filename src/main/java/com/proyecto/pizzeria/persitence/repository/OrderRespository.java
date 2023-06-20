package com.proyecto.pizzeria.persitence.repository;

import com.proyecto.pizzeria.persitence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRespository extends ListCrudRepository<OrderEntity,Integer> {
    List<OrderEntity> findAllByDateAfter(LocalDateTime date);
    List<OrderEntity> findAllByMethodIn(List<Character> method);
}
