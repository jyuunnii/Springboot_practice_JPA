package com.example.test.repository;

import com.example.test.TestApplicationTests;
import com.example.test.model.entity.User;
import com.sun.tools.classfile.Dependency;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest extends TestApplicationTests {

    /*
    @Autowired
    Dependency Injection (DI) 의존성 주입
    private UserRepository userRepository = new UserRepository();
    와 같이 개발자가 직접 객체 생성하지 않고 SpringBoot 가 직접 관
    */

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("testuser01");
        user.setEmail("testemail01");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user); //save 의 반환형도 User type
        System.out.println("newUser: "+newUser);

    }

    @Test
    public void read() {
        Optional<User> user = userRepository.findById(2L); //id=2

        user.ifPresent(selectUser ->{
            System.out.println("user: "+selectUser);
        });
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("testuser22");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("updated");

            userRepository.save(selectUser);
        });
    }

    @Test
    public void delete() {
        Optional<User> user = userRepository.findById(1L);

        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deletedUser = userRepository.findById(1L); //check

        Assert.assertFalse(deletedUser.isPresent());

    }
}
