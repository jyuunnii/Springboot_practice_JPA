package com.example.test.repository;

import com.example.test.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
//User의 id datatype : Long
/*
 Repository 를 통해 따로 쿼리문을 작성하지 않아도 기본적인 CRUD 수행 가능
 Create, Read(Select), Update, Delete
*/

