package com.geolidth.BackEnd.auth;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtAuthenticationResponse {
    private String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

}
