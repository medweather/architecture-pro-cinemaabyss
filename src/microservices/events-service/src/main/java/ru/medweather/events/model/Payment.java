package ru.medweather.events.model;

import java.time.LocalDateTime;

public record Payment(
        Long payment_id,
        Long user_id,
        Double amount,
        String status,
        LocalDateTime timestamp,
        String method_type
) {
}
