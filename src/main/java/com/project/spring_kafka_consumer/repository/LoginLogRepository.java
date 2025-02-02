package com.project.spring_kafka_consumer.repository;

import com.project.spring_kafka_consumer.entity.LoginLogVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogRepository extends JpaRepository<LoginLogVo, Long> {
}
