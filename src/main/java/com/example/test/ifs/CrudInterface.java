package com.example.test.ifs;

import com.example.test.model.network.Header;

public interface CrudInterface {

    Header create(); // todo 매개변수 추가

    Header read(Long id);

    Header update();

    Header delete(Long id);
}
