package com.project.spring_kafka_consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "myTopic", groupId = "testgroup")
    public void consume(String message) throws IOException {
        log.info("Message Received From Kafka Server: {} login", message);
    }
}
