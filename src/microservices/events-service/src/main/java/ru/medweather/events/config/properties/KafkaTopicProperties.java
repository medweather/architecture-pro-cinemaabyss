package ru.medweather.events.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "kafka-topic")
public class KafkaTopicProperties {

    private int partitions;
    private int replicas;
    private String retentionMs;
    private Names names;

    @Setter
    @Getter
    public static class Names {
        private String userTopic;
        private String paymentTopic;
        private String movieTopic;
    }
}
