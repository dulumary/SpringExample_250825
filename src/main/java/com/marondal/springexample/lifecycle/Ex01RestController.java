package com.marondal.springexample.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lifecycle/ex01")
@RestController // @Controller + @ResponseBody
public class Ex01RestController {

    // 직접 만든 클래스 객체 response에 담은 페이지
    @RequestMapping("/3")
    public Person personResponse() {
        Person me = new Person("김인규", 32);

        return me;
    }

    // status code 수정
    @RequestMapping("/4")
    public ResponseEntity<Person> statusResponse() {

        Person me = new Person("김인규", 32);

        ResponseEntity<Person> entity = new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);

        return entity;
    }

}
