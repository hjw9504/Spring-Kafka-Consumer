package com.project.spring_kafka_consumer.consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.spring_kafka_consumer.entity.LoginLogVo;
import com.project.spring_kafka_consumer.repository.LoginLogRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final LoginLogRepository loginLogRepository;

    @KafkaListener(topics = "auth_login", groupId = "auth_group")
    public void consume(String message) throws IOException {
        try {
            log.info("Message Received From Kafka Server: {} login", message);

            if (StringUtils.isEmpty(message)) {
                log.warn("Message is null");
                return;
            }

            Map<String, String> map = objectMapper.readValue(message, new TypeReference<Map<String, String>>() {});
            loginLogRepository.save(getMapToLoginLogVo(map));
        } catch(Exception e) {
            log.info("Exception: ", e);
        }
    }

    private LoginLogVo getMapToLoginLogVo(Map<String, String> map) {
        return LoginLogVo.builder()
                .memberId(map.get("memberId"))
                .name(map.get("name"))
                .build();
    }
}
