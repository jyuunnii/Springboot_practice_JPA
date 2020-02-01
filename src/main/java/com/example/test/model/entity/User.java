package com.example.test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity //==table
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderGroupList"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    //user 1:n ordergroup
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;

}

/*
 JPA 의 장점 :
 Query 를 계속 걸어서 select 해야하는 데이터를 jpa 연관관계 설정을 통해 객체를 활용하여 해당 값을 출력할 수 있음!

 Lombok builder 장점:
 생성자의 멤버변수는 entity의 변수 선언 순서와 동일해야함 + 변수의 자료형도 입력해야함
    => 차후 개발 단계에서 entity의 변수가 추가될 경우 수정해야하는 불편

  User newUser = new User(account, password, status, ...);
    => User.builder().account().email().build(); //필요한 데이터만 입력하여 불편함 해소!
 */