package com.example.bookingsticker.request;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
