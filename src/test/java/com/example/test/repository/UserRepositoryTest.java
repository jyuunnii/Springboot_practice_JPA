package com.example.test.repository;

import com.example.test.TestApplicationTests;
import com.example.test.model.entity.Item;
import com.example.test.model.entity.User;
import com.sun.tools.classfile.Dependency;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import javax.transaction.Transactional;
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
        user.setAccount("testuser02");
        user.setStatus("teststatus02");
        user.setEmail("testemail02");
        user.setPassword("testpassword02");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setCreatedBy("admin");

//        User newUser = userRepository.save(user); //save 의 반환형도 User type
//        Assert.assertNotNull(newUser);

        User buildUser = User.builder().account("testuser03").password("testpassword03").status("teststatus03").build(); //입력하고 싶은 정보만 입력

        User one = userRepository.save(buildUser);
        Assert.assertNotNull(one);
    }

    @Test
    @Transactional
    public void read() {

        User user = userRepository.findFirstByAccountOrderByIdDesc("testuser01");

        user.setPassword("testmodified01")
            .setStatus("testmodified01");

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);

//        user.getOrderGroupList().stream().forEach(o -> { // o : ordergroup
//            System.out.println("1) user x ordergroup 연관관계 : "+o.getArrivalDate());
//            o.getOrderDetailList().forEach(d -> {
//                System.out.println("2) ordergroup x orderdetail 연관관계 : "+d.getQuantity());
//                System.out.println("3) orderdetail x item 연관관계: "+ d.getItem().getName());
//                System.out.println("4) item x partner 연관관계 : "+ d.getItem().getPartner().getAddress());
//                System.out.println("5) partner x category 연관관계 : "+ d.getItem().getPartner().getCategory().getTitle());
//            });
//        });

        /*
         JPA 의 장점 :
         Query 를 계속 걸어서 select 해야하는 데이터를 jpa 연관관계 설정을 통해 객체를 활용하여 해당 값을 출력할 수 있음!

         Lombok Accssors 장점 :
         데이터 업데이트 시 편리
         user.setEmail("modified");
         user.setPassword("modified");
            => user.setEmail("m").setPassword("m")... 체인 형식!
         */

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
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deletedUser = userRepository.findById(3L); //check

        Assert.assertFalse(deletedUser.isPresent());

    }
}
