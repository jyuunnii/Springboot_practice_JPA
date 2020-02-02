package com.example.test.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {

    private Long id; //user db index

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;
}

/*
 비슷한 내용의 Request 와 Response 모델을 서로 다른 클래스로 관리하는 이유?
 request 할 때는 password 가 평문으로 입력되지만,
 response 할 때는 password 를 암호화해서 처리한다던지, 같은 변수를 다르게 정의해서 처리할 수도 있기 때문에
 */