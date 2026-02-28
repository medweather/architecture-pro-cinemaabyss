package ru.medweather.events.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.medweather.events.kafka.KafkaProducer;
import ru.medweather.events.model.Movie;
import ru.medweather.events.model.Payment;
import ru.medweather.events.model.User;
import ru.medweather.events.service.EventsService;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventsServiceImpl implements EventsService {

    private final KafkaProducer kafkaProducer;

    @Override
    public void createUser(User user) {
        kafkaProducer.pushUser(user);
    }

    @Override
    public void createPayment(Payment payment) {
        kafkaProducer.pussPayment(payment);
    }

    @Override
    public void createMovie(Movie movie) {
        kafkaProducer.pushMovie(movie);
    }
}
