package com.example.sdjpaorderservice2.repositories;

import com.example.sdjpaorderservice2.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByCustomerNameContainingIgnoreCase(String customerName);

}
