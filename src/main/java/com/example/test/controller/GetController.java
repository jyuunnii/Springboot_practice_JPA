package com.example.test.controller;

import com.example.test.model.SearchParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path="/getMethod")
    public String getRequest(){
        return "OK";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam String password){
        System.out.println("id: "+id);
        System.out.println("password: "+password);
        return id+password;
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;
    }
}
