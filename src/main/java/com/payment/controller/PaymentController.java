package com.payment.controller;

import com.payment.model.Payment;
import com.payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody CreatePaymentRequest req) {
        var p = service.createPayment(req.getUserId(), req.getAmount(), req.getCurrency());
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> get(@PathVariable String id) {
        Payment p = service.getById(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    public static class CreatePaymentRequest {
        private Long userId;
        private Long amount;
        private String currency;

        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public Long getAmount() { return amount; }
        public void setAmount(Long amount) { this.amount = amount; }
        public String getCurrency() { return currency; }
        public void setCurrency(String currency) { this.currency = currency; }
    }
}