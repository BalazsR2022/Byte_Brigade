package com.geolidth.BackEnd.models.dao;

import com.geolidth.BackEnd.models.dao.BookUser;
import com.geolidth.BackEnd.models.dao.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
@Data
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private BookUser user;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}