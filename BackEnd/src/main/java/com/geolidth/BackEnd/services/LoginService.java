package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.exceptions.WrongUsernameOrPasswordException;
import com.geolidth.BackEnd.models.dto.Login;
import com.geolidth.BackEnd.models.dto.Token;
import org.springframework.stereotype.Service;


public interface LoginService {

    Token login(Login login) throws WrongUsernameOrPasswordException;

}
