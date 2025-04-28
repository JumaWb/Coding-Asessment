package com.example.b2cpaymentservice.service.sms;

import com.example.b2cpaymentservice.dto.SMSRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class SMSNotificationServiceImpl implements SMSNotificationService {

    private final WebClient webClient = WebClient.create(); // Normally should inject

    @Override
    public void sendSMS(SMSRequest smsRequest) {
        try {
            webClient.post()
                    .uri("http://localhost:8082/mock-sms")
                    .bodyValue(smsRequest)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();
            log.info("SMS sent to {}", smsRequest.getPhoneNumber());
        } catch (Exception e) {
            log.error("Failed to send SMS", e);
        }
    }
}
