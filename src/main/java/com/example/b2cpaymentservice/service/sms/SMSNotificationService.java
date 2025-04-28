package com.example.b2cpaymentservice.service.sms;

import com.example.b2cpaymentservice.dto.SMSRequest;

public interface SMSNotificationService {
    void sendSMS(SMSRequest request);
}
