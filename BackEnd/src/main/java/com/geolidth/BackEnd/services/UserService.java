package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.auth.UserCredentials;
import com.geolidth.BackEnd.models.dao.Book;
import com.geolidth.BackEnd.models.dao.BookUser;
import com.geolidth.BackEnd.models.dto.NewUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDetails loadUserByUsername(String username);

    BookUser save(BookUser newUser);

    BookUser getById(Integer id);

    String login(UserCredentials userCredentials);

    Book addBook(Book book);

    BookUser updateUser(Integer userId, NewUser userDetails);

    void deleteUser(Integer userId);

    void updateUserData(Integer userId, NewUser userDetails);

    void deleteUserData(Integer userId);

    void reserveBook(Long bookId, Integer userId);

    BookUser findUserByUsername(String username);

    List<BookUser> getAllUsers();

    Book findBookById(Integer id);

    boolean existsByUsername(String username);
}