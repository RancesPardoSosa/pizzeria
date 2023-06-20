package com.proyecto.pizzeria.service;

import com.proyecto.pizzeria.persitence.entity.CustomerEntity;
import com.proyecto.pizzeria.persitence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity getByPhone(String phone){
        return this.customerRepository.findByPhone(phone);
    }
}
