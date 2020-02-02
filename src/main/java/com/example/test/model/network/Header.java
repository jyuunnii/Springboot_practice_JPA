package com.example.test.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    //api 통신 시간
    @JsonProperty("transaction_time") // camelCase => snake_case 직접 변경
    private LocalDateTime transactionTime;

    //api 응답 코드
    private String resultCode;

    //api 부가 설명
    private String description;

    private T data; // body: 응답에서 계속 변하는 부분

    //OK
    public static <T>Header<T>  OK(){
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now())
                                .resultCode("OK")
                                .description("OK")
                                .build();
    }
    //Data OK
    public static <T>Header<T>  OK(T data){
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    //Error
    public static <T>Header<T>  Error(String description){
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }
}
/*
 header: API 응답에서 공통적으로 들어가는 부분
 */
