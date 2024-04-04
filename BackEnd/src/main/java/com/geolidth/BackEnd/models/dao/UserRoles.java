package com.geolidth.BackEnd.models.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "user_roles")
@Data
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private BookUser user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}