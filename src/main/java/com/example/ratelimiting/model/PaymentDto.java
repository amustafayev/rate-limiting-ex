package com.example.ratelimiting.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentDto {
    private Long id;
    private Double amount;
    private String description;
}
