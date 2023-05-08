package com.example.authenservice.controller;

import com.example.authenservice.request.LoginRequest;
import com.example.authenservice.service.AuthenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/authen")
@Slf4j
public class Controller {
    @Autowired
    private AuthenService authenService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        log.info("into instance");
        return ResponseEntity.ok(authenService.login(loginRequest));
    }
}
