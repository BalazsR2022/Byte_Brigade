package com.geolidth.BackEnd.Controllers;

import com.geolidth.BackEnd.models.dto.Login;
import com.geolidth.BackEnd.models.dto.Token;
import com.geolidth.BackEnd.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody Login login) {
        return ResponseEntity.status(OK).body(loginService.login(login));


    }
}
