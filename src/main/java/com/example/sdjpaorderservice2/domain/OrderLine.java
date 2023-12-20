package com.example.sdjpaorderservice2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class OrderLine extends BaseEntity{

    private Integer quantityOrdered;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private OrderHeader orderHeader;

    @ManyToOne
    private Product product;

    @Version
    private Integer version;

    public OrderLine() {}
}
