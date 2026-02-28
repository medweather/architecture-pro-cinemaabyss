package ru.medweather.events.model;

import java.time.LocalDateTime;

public record User(
        Long user_id,
        String username,
        String action,
        LocalDateTime timestamp
) {
}
