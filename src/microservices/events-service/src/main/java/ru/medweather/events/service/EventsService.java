package ru.medweather.events.service;

import ru.medweather.events.model.Movie;
import ru.medweather.events.model.Payment;
import ru.medweather.events.model.User;

public interface EventsService {
    void createUser(User user);

    void createPayment(Payment payment);

    void createMovie(Movie movie);
}
