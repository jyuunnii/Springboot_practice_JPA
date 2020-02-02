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

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    //todo 1. select request data
    //todo 2. create user object
    //todo 3. return user-api-response => crud 에서 모두 활용하기 위해 따로 빼서 response 함수 생성

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        //todo1
        UserApiRequest userApiRequest = request.getData();

        //todo2
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("teststatus")
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);

        //todo3
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
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