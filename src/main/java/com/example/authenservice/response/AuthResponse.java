package com.example.authenservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
public class AuthResponse{
    private String sessionId;
    private String token;
}
