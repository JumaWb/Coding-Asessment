package com.example.b2cpaymentservice.controller;

import com.example.b2cpaymentservice.dto.B2CPaymentRequest;
import com.example.b2cpaymentservice.dto.B2CPaymentResponse;
import com.example.b2cpaymentservice.service.b2c.B2CPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class B2CPaymentController {

    private final B2CPaymentService b2CPaymentService;

    @PostMapping
    public B2CPaymentResponse initiatePayment(@RequestBody B2CPaymentRequest request) {
        return b2CPaymentService.initiateB2CPayment(request);
    }
}
