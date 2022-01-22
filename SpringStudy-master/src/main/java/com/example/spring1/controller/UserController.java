package com.example.spring1.controller;

import com.example.spring1.dto.UserForm;
import com.example.spring1.entity.User;
import com.example.spring1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController //Rest API 용 컨트롤러, 데이터(JSON)를 반환
public class UserController {
    @Autowired  //DI
    private UserService userService;
    
    //POST
    @PostMapping("/users/create")
    public ResponseEntity<User> create(@RequestBody UserForm dto){
        log.info(dto.toString());
        User created = userService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //POST, 로그인하기
    @PostMapping("/api/login")
    public ResponseEntity<User> login(@RequestBody UserForm dto){
        log.info(dto.toString());
        User login = userService.login(dto);
        return (login != null) ?
                ResponseEntity.status(HttpStatus.OK).body(login):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/users/check_email")
    public ResponseEntity<Boolean> checkEmail(@RequestBody UserForm dto){
        log.info(dto.toString());
        boolean status = userService.checkEmail(dto);
        return (status != true) ?
                ResponseEntity.status(HttpStatus.OK).body(status):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }






}
