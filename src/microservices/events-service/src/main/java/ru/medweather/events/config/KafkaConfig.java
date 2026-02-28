package ru.medweather.events.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import ru.medweather.events.config.properties.KafkaTopicProperties;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

    private final KafkaTopicProperties properties;

    @Bean
    public NewTopic userTopic() {
        return TopicBuilder.name(properties.getNames().getUserTopic())
                .partitions(properties.getPartitions())
                .replicas(properties.getReplicas())
                .config(TopicConfig.RETENTION_MS_CONFIG, properties.getRetentionMs())
                .config(TopicConfig.LOCAL_LOG_RETENTION_MS_CONFIG, properties.getRetentionMs())
                .build();
    }

    @Bean
    public NewTopic paymentTopic() {
        return TopicBuilder.name(properties.getNames().getPaymentTopic())
                .partitions(properties.getPartitions())
                .replicas(properties.getReplicas())
                .config(TopicConfig.RETENTION_MS_CONFIG, properties.getRetentionMs())
                .config(TopicConfig.LOCAL_LOG_RETENTION_MS_CONFIG, properties.getRetentionMs())
                .build();
    }

    @Bean
    public NewTopic movieTopic() {
        return TopicBuilder.name(properties.getNames().getMovieTopic())
                .partitions(properties.getPartitions())
                .replicas(properties.getReplicas())
                .config(TopicConfig.RETENTION_MS_CONFIG, properties.getRetentionMs())
                .config(TopicConfig.LOCAL_LOG_RETENTION_MS_CONFIG, properties.getRetentionMs())
                .build();
    }
}
