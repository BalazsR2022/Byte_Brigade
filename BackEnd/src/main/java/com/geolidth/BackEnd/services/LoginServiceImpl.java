package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.exceptions.WrongUsernameOrPasswordException;
import com.geolidth.BackEnd.models.dto.Login;
import com.geolidth.BackEnd.models.dto.Token;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private  UserService userService;
    private PasswordEncoder passwordEncoder;

    @Override
    public Token login(Login login) throws WrongUsernameOrPasswordException {
        try {
            UserDetails user = userService.loadUserByUsername(login.getUsername());
            if (passwordEncoder.matches(login.getPassword(), user.getPassword())) {
                return new Token("cfjvbh");
            } else {
                throw new WrongUsernameOrPasswordException();
            }
        } catch (UsernameNotFoundException e) {
            throw new WrongUsernameOrPasswordException();
        }

    }


}
