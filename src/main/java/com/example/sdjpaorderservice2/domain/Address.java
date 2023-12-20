package com.example.sdjpaorderservice2.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

@Embeddable
@Data
public class Address {
    @Size(max=30)
    private String address;

    @Size(max=30)
    private String city;

    @Size(max=30)
    private String state;

    @Size(max=30)
    private String zipCode;

    public Address() {}
}
