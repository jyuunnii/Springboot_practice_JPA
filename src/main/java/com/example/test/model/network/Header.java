package com.example.test.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header {

    //api 통신 시간
    private  String transactionTime;

    //api 응답 코드
    private String resultCode;

    //api 부가 설명
    private String description;

}
/*
 API 응답에서 공통적으로 들어가는 부분
 */
