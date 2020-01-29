package com.example.test.repository;

import com.example.test.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAccount(String account); //1개

    Optional<User> findByAccountAndEmail(String account, String email); //2개 이상


}
//User의 id datatype : Long
/*
 Repository 를 통해 따로 쿼리문을 작성하지 않아도 기본적인 CRUD 수행 가능
 Create, Read(Select), Update, Delete
*/

//Query Method
/*
 일반적인 검색은 id가 아닌, 이름, 이메일, 번호 등 다른 속성을 통해서 검색함
 JPA 에서 제공하는 검색방법 query method!

 findBy가 오면 JPA가 자동으로 select문이라고 인식하고 '뒤의 값과(Account)' 매칭시켜 검색
 select * from user where account = ?
 */
