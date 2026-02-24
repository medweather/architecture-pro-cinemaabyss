package ru.medweather.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("ru.medweather.events")
public class EventsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventsServiceApplication.class, args);
    }

}
