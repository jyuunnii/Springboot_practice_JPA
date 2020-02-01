package com.example.test.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    //api 통신 시간
    @JsonProperty("transaction_time") // camelCase => snake_case 직접 변경
    private  String transactionTime;

    //api 응답 코드
    private String resultCode;

    //api 부가 설명
    private String description;

    private T data; // body: 응답에서 계속 변하는 부분
}
/*
 header: API 응답에서 공통적으로 들어가는 부분
 */
