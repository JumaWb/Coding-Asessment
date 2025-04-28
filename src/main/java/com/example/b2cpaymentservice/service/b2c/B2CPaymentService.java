package com.example.b2cpaymentservice.service.b2c;

import com.example.b2cpaymentservice.dto.B2CPaymentRequest;
import com.example.b2cpaymentservice.dto.B2CPaymentResponse;

public interface B2CPaymentService {
    B2CPaymentResponse initiateB2CPayment(B2CPaymentRequest request);
}
