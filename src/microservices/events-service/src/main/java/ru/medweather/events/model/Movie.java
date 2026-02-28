package ru.medweather.events.model;

public record Movie(
        Long movie_id,
        String title,
        String action,
        Long user_id
) {
}
