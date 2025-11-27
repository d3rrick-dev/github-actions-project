package com.payment.model;

import java.time.Instant;

public class Payment {
    private String id;
    private Long userId;
    private Long amount;
    private String currency;
    private String status;
    private Instant createdAt;

    public Payment() {}

    public Payment(String id, Long userId, Long amount, String currency, String status) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.createdAt = Instant.now();
    }
}
