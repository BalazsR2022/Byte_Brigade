package com.geolidth.BackEnd.auth;

import com.geolidth.BackEnd.exceptions.WrongUsernameOrPasswordException;
import com.geolidth.BackEnd.models.UserRole;
import com.geolidth.BackEnd.models.dao.BookUser;
import com.geolidth.BackEnd.models.dao.UserRoles;
import com.geolidth.BackEnd.models.dto.NewUser;
import com.geolidth.BackEnd.models.dto.UserRolesDTO;
import com.geolidth.BackEnd.services.JwtTokenService;
import com.geolidth.BackEnd.services.RoleService;
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
import com.geolidth.BackEnd.models.dao.BookUser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenService jwtTokenService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenService jwtTokenService,
                          UserService userService,
                          PasswordEncoder passwordEncoder,
                          RoleService roleService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
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
    public ResponseEntity<?> registerUser(@RequestBody NewUser newUserRequest) {
        String username = newUserRequest.getUsername();
        String password = newUserRequest.getPassword();

        if (userService.existsByUsername(username)) {
            return ResponseEntity.badRequest().body("A felhasználónév már foglalt.");
        }

        if (password == null || password.isEmpty()) {
            return ResponseEntity.badRequest().body("A jelszó nem lehet üres.");
        }

        BookUser newUser = new BookUser();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(newUserRequest.getEmail());
        newUser.setRole(UserRole.Role.GUEST_ROLE); // Alapértelmezett szerepkör beállítása

        // Ha az új felhasználó admin, akkor megváltoztatjuk a szerepkörét
        if (username.equals("Laci") || username.equals("Réka") || username.equals("Dia")) {
            newUser.setRole(UserRole.Role.ADMIN_ROLE);
        }

        userService.save(newUser);

        UserDetails userDetails = userService.loadUserByUsername(username);
        String token = jwtTokenService.generateToken(userDetails);

        return ResponseEntity.ok("Sikeres regisztráció.");
    }
}

