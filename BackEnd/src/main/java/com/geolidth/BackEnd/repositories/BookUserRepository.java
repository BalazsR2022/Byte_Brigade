package com.geolidth.BackEnd.repositories;

import com.geolidth.BackEnd.models.dao.BookUser;
import org.springframework.data.repository.CrudRepository;

public interface BookUserRepository extends CrudRepository<BookUser, Integer> {
}
