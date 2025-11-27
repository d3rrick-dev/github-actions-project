package com.payment.service;

import com.payment.model.Payment;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PaymentService {
    private final Map<String, Payment> store = new ConcurrentHashMap<>();

    public Payment createPayment(Long userId, Long amount, String currency) {
        var id = UUID.randomUUID().toString();
        var p = new Payment(id, userId, amount, currency, "CREATED");
        store.put(id, p);
        return p;
    }

    public Payment getById(String id) {
        return store.get(id);
    }
}
