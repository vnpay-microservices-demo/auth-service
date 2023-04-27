package com.example.authenservice.controller;

import com.example.authenservice.request.LoginRequest;
import com.example.authenservice.service.AuthenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authen")
public class Controller {
    @Autowired
    private AuthenService authenService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authenService.login(loginRequest));
    }
}
