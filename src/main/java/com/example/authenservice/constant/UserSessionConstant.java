package com.example.authenservice.constant;

import java.util.UUID;

public class UserSessionConstant {
    public static String getUserSessionId(String userId){
        return UUID.randomUUID().toString() + userId;
    }
}
