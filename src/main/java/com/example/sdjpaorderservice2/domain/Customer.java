package com.example.sdjpaorderservice2.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
public class Customer extends BaseEntity {

    @Size(max = 50)
    private String customerName;

    @Valid
    @Embedded
    private Address address;

    @Size(max=30)
    private String phone;

    @Email
    private String email;

    @Version
    private Integer version;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "customer")
    private Set<OrderHeader> orders = new LinkedHashSet<>();

    public Customer() {}
}
