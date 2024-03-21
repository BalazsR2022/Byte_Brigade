package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.exceptions.NoSuchUserException;
import com.geolidth.BackEnd.models.dao.BookUser;
import com.geolidth.BackEnd.models.dto.NewUser;
import com.geolidth.BackEnd.repositories.BookUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private BookUserRepository userRepository;
    @Override
    public BookUser getById(Integer id) throws NoSuchUserException {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchUserException(id));
    }

    @Override
    public BookUser save(NewUser newUser) {
        return userRepository.save(convertToUser(newUser));
    }

    private BookUser convertToUser(NewUser newUser) {
        BookUser user = new BookUser();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());     // Teendő: password titkosítása!!!
        return  user;
    }
}
