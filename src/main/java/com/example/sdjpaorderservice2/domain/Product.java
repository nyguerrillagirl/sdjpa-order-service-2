package com.example.sdjpaorderservice2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Entity
@Data
public class Product extends BaseEntity {
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    private Integer quantityOnHand = 0;

    public Product() {}
}
