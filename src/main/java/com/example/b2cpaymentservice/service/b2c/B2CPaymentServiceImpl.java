package com.example.b2cpaymentservice.service.b2c;

import com.example.b2cpaymentservice.dto.B2CPaymentRequest;
import com.example.b2cpaymentservice.dto.B2CPaymentResponse;
import com.example.b2cpaymentservice.dto.SMSRequest;
import com.example.b2cpaymentservice.model.TransactionLog;
import com.example.b2cpaymentservice.repository.TransactionLogRepository;
import com.example.b2cpaymentservice.service.sms.SMSNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class B2CPaymentServiceImpl implements B2CPaymentService {

    private final TransactionLogRepository transactionLogRepository;
    private final SMSNotificationService smsNotificationService;

    private final WebClient webClient = WebClient.create(); // Normally should inject

    @Override
    public B2CPaymentResponse initiateB2CPayment(B2CPaymentRequest request) {
        try {
            // Call mock B2C Payment API (simulate)
            String response = webClient.post()
                    .uri("http://localhost:8081/mock-b2c-payment") // your mock server endpoint
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            TransactionLog log = TransactionLog.builder()
                    .phoneNumber(request.getPhoneNumber())
                    .amount(request.getAmount())
                    .accountReference(request.getAccountReference())
                    .status("SUCCESS")
                    .timestamp(LocalDateTime.now())
                    .build();
            transactionLogRepository.save(log);

            smsNotificationService.sendSMS(new SMSRequest(request.getPhoneNumber(), "Payment Successful!"));

            return new B2CPaymentResponse("SUCCESS", "Payment initiated successfully.");
        } catch (Exception e) {
            log.error("Payment failed", e);
            smsNotificationService.sendSMS(new SMSRequest(request.getPhoneNumber(), "Payment Failed!"));
            return new B2CPaymentResponse("FAILED", "Payment initiation failed.");
        }
    }
}
