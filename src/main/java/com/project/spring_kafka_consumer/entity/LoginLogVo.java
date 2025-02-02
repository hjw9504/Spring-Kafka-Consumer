package com.project.spring_kafka_consumer.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "loginLog")
public class LoginLogVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "member_id")
    private String memberId;
    private String name;

    @Builder
    public LoginLogVo(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}
