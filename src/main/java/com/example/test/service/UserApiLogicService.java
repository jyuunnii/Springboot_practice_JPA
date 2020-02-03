package com.example.test.service;

import com.example.test.ifs.CrudInterface;
import com.example.test.model.entity.User;
import com.example.test.model.network.Header;
import com.example.test.model.network.request.UserApiRequest;
import com.example.test.model.network.response.UserApiResponse;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    //todo 1. get request data
    //todo 2. create user object
    //todo 3. return user-api-response => crud 에서 모두 활용하기 위해 따로 빼서 response 함수 생성

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        //1) get request data
        UserApiRequest userApiRequest = request.getData();

        //2) create user object
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("teststatus")
                .email(userApiRequest.getEmail())
                .phoneNumber(userApiRequest.getPhoneNumber())
                .registeredAt(LocalDateTime.now())
                .unregisteredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);

        //3) user-api-response return
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        // 1) id -> repository -> getOne, getById -> return data
        Optional<User> optuser = userRepository.findById(id);

        // 2) user -> user-api-response return
        return optuser.map(u -> response(u)) //lambda
                    .orElseGet( //에러처리
                        ()-> Header.Error("no data")
                    );
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        //1) get request data

        UserApiRequest userApiRequest = request.getData();

        //2) id -> select user data
        Optional<User> optuser = userRepository.findById(userApiRequest.getId());

        return optuser.map(u -> {
            //3) update
            u.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setEmail(userApiRequest.getEmail())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());

            User updatedUser = userRepository.save(u);

            //4) user-api-response return
            return response(updatedUser);
        }).orElseGet(()->Header.Error("no data"));
    }

    @Override
    public Header delete(Long id) {
        // 1) id -> repository -> getOne, getById -> return data
        Optional<User> optuser = userRepository.findById(id);

        return optuser.map(u -> {

            userRepository.delete(u);    // 2) repository -> delete

            return Header.OK();  // 3) user-api-response return

        }).orElseGet(() -> Header.Error("no data"));
    }

    //todo3
    private Header<UserApiResponse> response(User user){

        UserApiResponse userApiResponse = UserApiResponse.builder()
                                                            .id(user.getId())
                                                            .account(user.getAccount())
                                                            .password(user.getPassword()) //todo 암호화, 길이 제한
                                                            .status(user.getStatus())
                                                            .registeredAt(user.getRegisteredAt())
                                                            .unregisteredAt(user.getUnregisteredAt())
                                                            .build();

        // response 완전체 : header + data
        return Header.DataOK(userApiResponse);
    }
}

/*
프로젝트의 서비스 로직을 담당하는 패키지
특정 데이터를 생성, 변경, 수정
 */