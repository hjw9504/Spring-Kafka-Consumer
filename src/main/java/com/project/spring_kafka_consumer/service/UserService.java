package com.project.spring_kafka_consumer.service;

import com.project.spring_kafka_consumer.repository.LoginLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.lang.reflect.Member;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final LoginLogRepository memberRepository;

    public void checkId(String id, String memberId) {

    }

}
