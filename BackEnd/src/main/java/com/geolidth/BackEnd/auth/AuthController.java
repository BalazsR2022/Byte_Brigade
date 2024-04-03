package com.geolidth.BackEnd.auth;

import com.geolidth.BackEnd.exceptions.WrongUsernameOrPasswordException;
import com.geolidth.BackEnd.models.dao.BookUser;
import com.geolidth.BackEnd.services.JwtTokenService;
import com.geolidth.BackEnd.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenService jwtTokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenService jwtTokenService,
                          UserService userService,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
            String token = jwtTokenService.generateToken(userDetails);

            return ResponseEntity.ok(new JwtAuthenticationResponse(token));
        } catch (WrongUsernameOrPasswordException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserCredentials userCredentials) {
        String username = userCredentials.getUsername();
        String password = userCredentials.getPassword();

        if (userService.existsByUsername(username)) {
            return ResponseEntity.badRequest().body("A felhasználónév már foglalt.");
        }

        if (password == null || password.isEmpty()) {
            return ResponseEntity.badRequest().body("A jelszó nem lehet üres.");
        }

        BookUser newUser = new BookUser();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));


        userService.save(newUser);

        BookUser savedUser = userService.findUserByUsername(username);
        if (savedUser != null) {
            UserDetails userDetails = userService.loadUserByUsername(username);
            String token = jwtTokenService.generateToken(userDetails);

            return ResponseEntity.ok("Sikeres regisztráció.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sikertelen regisztráció.");
        }
    }
}