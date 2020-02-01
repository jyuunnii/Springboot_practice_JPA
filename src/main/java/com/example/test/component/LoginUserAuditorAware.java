package com.example.test.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginUserAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("AdminServer"); //default 값 설정 => createdBy, updatedBy 값으로 입력됨
    }
}
/*
 로그인 한 사용자 감시
 implements method!
 */