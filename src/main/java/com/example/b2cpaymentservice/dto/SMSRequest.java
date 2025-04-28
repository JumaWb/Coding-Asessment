package com.example.b2cpaymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SMSRequest {
    private String phoneNumber;
    private String message;
}
