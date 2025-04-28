package com.example.b2cpaymentservice.dto;

import lombok.Data;

@Data
public class B2CPaymentRequest {
    private String phoneNumber;
    private Double amount;
    private String accountReference;
}
