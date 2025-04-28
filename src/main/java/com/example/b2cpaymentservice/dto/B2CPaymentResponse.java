package com.example.b2cpaymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class B2CPaymentResponse {
    private String status;
    private String message;
}
