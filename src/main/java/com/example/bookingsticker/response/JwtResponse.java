package com.example.bookingsticker.response;

import lombok.Data;

@Data
public class JwtResponse {

    private String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
}
