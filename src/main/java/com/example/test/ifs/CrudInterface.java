package com.example.test.ifs;

import com.example.test.model.network.Header;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Req request); // todo 매개변수 추가

    Header<Res> read(Long id);

    Header<Res> update(Req request);

    Header delete(Long id);
}

/*

다른 entity에도 crud interface 를 활용하기 위해
"" Header create(UserApiRequest request) ""와 같이 매개변수를 특정 ApiRequest 클래스로 받지 않음!
특정 클래스로 받으면 다른 ItemApiController에 CrudInterface 상속받아 crud 생성하면 defualt값으로 적합하지 않은(UserApiRequest) 형식이 상속됨,,
=> Generics 으로 관리
=> 모든 controller 가 동일한 interface를 상속받을 수 있음


[잘못된 예시]
@RestController
@RequestMapping("api/user")
public class UserApiController implements CrudInterface {


    @Override
    @PostMapping("") //api/user
    public Header<UserApiResponse> create(@RequestBody UserApiRequest userApiRequest) {
        return null;
    }
...
}

[올바른 예시]
@RestController
@RequestMapping("api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {


    @Override
    @PostMapping("") //api/user
    public Header<UserApiResponse> create(@RequestBody UserApiRequest userApiRequest) {
        return null;
    }
...
}

 */