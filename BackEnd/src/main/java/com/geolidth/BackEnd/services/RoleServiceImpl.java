package com.geolidth.BackEnd.services;

import com.geolidth.BackEnd.models.UserRole;
import com.geolidth.BackEnd.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserRole> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void addRole(UserRole role) {
        roleRepository.save(role);
    }

    @Override
    public void updateRole(UserRole role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRoleById(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public UserRole getRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}



//@Service
//public static class RoleService {

  //     return Arrays.asList(UserRole.values());
  //  }
  //  }

   // public UserRole getRoleByName(String name) throws NoSuchUserException {
   //     for (UserRole role : UserRole.values()) {
   //         if (role.name().equalsIgnoreCase(name)) {
   //             return role;
    //        }
   //     }
     //   throw new NoSuchUserException();
   //}


