package com.geolidth.BackEnd.repositories;

import com.geolidth.BackEnd.models.dao.BookUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookUserRepository extends CrudRepository<BookUser, Integer> {

    Optional<BookUser> findByUsername(String username);
}
