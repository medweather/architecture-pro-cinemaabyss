package ru.medweather.events.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.medweather.events.config.properties.KafkaTopicProperties;
import ru.medweather.events.model.Movie;
import ru.medweather.events.model.Payment;
import ru.medweather.events.model.User;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTopicProperties properties;
    private final KafkaTemplate<String, User> userTemplate;
    private final KafkaTemplate<String, Payment> paymentTemplate;
    private final KafkaTemplate<String, Movie> movieTemplate;

    public void pushUser(User user) {
        userTemplate.send(
                properties.getNames().getUserTopic(),
                user
        );
        log.info("User {} sent to topic {}", user, properties.getNames().getUserTopic());
    }

    public void pussPayment(Payment payment) {
        paymentTemplate.send(
                properties.getNames().getPaymentTopic(),
                payment
        );
        log.info("Payment {} sent to topic {}", payment, properties.getNames().getPaymentTopic());
    }

    public void pushMovie(Movie movie) {
        movieTemplate.send(
                properties.getNames().getMovieTopic(),
                movie
        );
        log.info("Movie {} sent to topic {}", movie, properties.getNames().getMovieTopic());
    }
}
