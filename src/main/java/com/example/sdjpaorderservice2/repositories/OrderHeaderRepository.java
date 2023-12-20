package com.example.sdjpaorderservice2.repositories;

import com.example.sdjpaorderservice2.domain.Customer;
import com.example.sdjpaorderservice2.domain.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Integer> {
    List<OrderHeader> findAllByCustomer(Customer customer);

}
