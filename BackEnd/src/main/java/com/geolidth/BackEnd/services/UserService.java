package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.exceptions.NoSuchUserException;
import com.geolidth.BackEnd.models.dao.BookUser;
import com.geolidth.BackEnd.models.dto.NewUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {
    BookUser getById(Integer id) throws NoSuchUserException;
    BookUser save(NewUser newUser);
}
