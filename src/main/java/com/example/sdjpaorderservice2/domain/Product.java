package com.example.sdjpaorderservice2.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Entity
@Data
public class Product extends BaseEntity {
    @Size(max=100)
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    private Integer quantityOnHand = 0;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name="product_category",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Category> categories;

    public Product() {}
}
