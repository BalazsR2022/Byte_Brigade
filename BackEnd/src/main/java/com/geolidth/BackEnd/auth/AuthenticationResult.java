package com.geolidth.BackEnd.auth;

import lombok.Getter;
import org.springframework.security.core.Authentication;


public class AuthenticationResult {

    private final boolean success;
    private final Authentication authentication;

    public AuthenticationResult(boolean success, Authentication authentication) {
        this.success = success;
        this.authentication = authentication;
    }

}