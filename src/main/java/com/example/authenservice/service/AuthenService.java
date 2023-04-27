package com.example.authenservice.service;

import com.example.authenservice.constant.UserSessionConstant;
import com.example.authenservice.exception.BadRequestException;
import com.example.authenservice.request.LoginRequest;
import com.example.authenservice.response.AuthResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenService {
    private static final BCryptPasswordEncoder B_CRYPT_ENCODER = new BCryptPasswordEncoder();
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Value("${application.authentication.access_token.life_time}")
    private long tokenLifeTime;
    @Value("${application.authentication.access_token.secret}")
    private String jwtSecret;

    public AuthResponse login(LoginRequest loginRequest){
        if(!B_CRYPT_ENCODER.matches(loginRequest.getPassword(),
                userService.loadUserByUsername(loginRequest.getUsername()).getPassword())){
            throw new BadRequestException("Invalid username or password.");
        }
        String userid = userService.loadUserByUsername(loginRequest.getUsername()).getId();
        return AuthResponse.of(UserSessionConstant.getUserSessionId(userid), generateAccessToken(userid,loginRequest.getUsername()));
    }
    private String generateAccessToken(String userId, String username){
        Map<String,Object> claims = new HashMap<>();
        claims.put("username",username);
        return jwtGenerate(userId,claims,this.tokenLifeTime,this.jwtSecret);
    }
    private String jwtGenerate(String subject, Map<String, Object> claims, long tokenLifeTime, String jwtSecret){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + tokenLifeTime))
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS256,jwtSecret)
                .compact();
    }
}
