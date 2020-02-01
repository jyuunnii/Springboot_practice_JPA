package com.example.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
/*
    Entity에서 공통적으로 사용되는 부분을 jpa 를 활용하여 간단하게 설정하기
    수정이 일어나면 자동으로 갱신

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
 */