package com.geolidth.BackEnd.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "user_role")
public class UserRole {


    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public enum Role {
        ADMIN_ROLE,
        USER_ROLE,
        GUEST_ROLE
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

}