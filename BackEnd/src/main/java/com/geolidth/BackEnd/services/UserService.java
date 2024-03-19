package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.exceptions.NoSuchUserException;
import com.geolidth.BackEnd.models.dao.BookUser;
import org.springframework.stereotype.Service;


public interface UserService {
    BookUser getById(Integer id) throws NoSuchUserException;
}
