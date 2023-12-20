package com.example.sdjpaorderservice2.repositories;

import com.example.sdjpaorderservice2.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByDescription(String description);
}
