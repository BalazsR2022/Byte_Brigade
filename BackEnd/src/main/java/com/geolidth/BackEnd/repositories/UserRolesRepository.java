package com.geolidth.BackEnd.repositories;

import com.geolidth.BackEnd.models.dao.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {
}