package ru.medweather.events.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.medweather.events.model.Movie;
import ru.medweather.events.model.Payment;
import ru.medweather.events.model.User;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka-topic.names.user-topic}")
    public void receiveUser(User user) {
        log.info("Received user {}", user);
    }

    @KafkaListener(topics = "${kafka-topic.names.payment-topic}")
    public void receivePayment(Payment payment) {
        log.info("Received payment {}", payment);
    }

    @KafkaListener(topics = "${kafka-topic.names.movie-topic}")
    public void receiveMovie(Movie movie) {
        log.info("Received movie {}", movie);
    }
}
