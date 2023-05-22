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
    private static final long start = System.currentTimeMillis();
    private static final  long end = start + 10000;
    @Autowired
    private AuthenService authenService;
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws InterruptedException {
//        log.info("into instance");
//        return ResponseEntity.ok(authenService.login(loginRequest));
//    }
    @PostMapping("/login")
<<<<<<< HEAD
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws InterruptedException {
        log.info("into instance");
        log.info("end date is: {}", end);
        long currenDate = System.currentTimeMillis();
        log.info("current date is: {}", currenDate);
        if(currenDate < end){
            return ResponseEntity.ok("data from instance error");
        }
        return ResponseEntity.internalServerError().build();
=======
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authenService.login(loginRequest));
>>>>>>> parent of 8823946 (update)
    }
}
