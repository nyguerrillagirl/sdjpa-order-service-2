package com.example.sdjpaorderservice2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class OrderApproval extends BaseEntity {

    private String approvedBy;

    @OneToOne
    @JoinColumn(name = "order_header_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private OrderHeader orderHeader;

    public OrderApproval() {}
}
