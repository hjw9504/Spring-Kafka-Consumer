package com.project.spring_kafka_consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "auth_login", groupId = "auth_group")
    public void consume(String message) throws IOException {
        try {
            log.info("Message Received From Kafka Server: {} login", message);
            Map<String, Object> map = objectMapper.readValue(message, new TypeReference<Map<String, Object>>() {});
            log.info("MemberId: {}, Name: {}", map.get("memberId"), map.get("name"));
        } catch(Exception e) {
            log.info("Exception: ", e);
        }
    }
}
