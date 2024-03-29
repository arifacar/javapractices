package com.arifacar.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Consumer App
 */
@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    //@Bean
    public NewTopic topic() {
        return TopicBuilder.name("topicPerson")
                .partitions(5)
                .replicas(2)
                .build();
    }

    @KafkaListener(id = "test", topics = "topicPerson")
    public void listen(String in) {
        System.out.println(in);
    }

}
