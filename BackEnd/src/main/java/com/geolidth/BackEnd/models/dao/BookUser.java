package com.geolidth.BackEnd.models.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.geolidth.BackEnd.models.UserRole;
import com.geolidth.BackEnd.models.dto.NewUser;
import lombok.*;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookusers")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BookUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter
    @Getter
    @Column(length = 50)
    private String username;
    @Setter
    @Getter
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String email;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserRoles> roles;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole.Role role;
    private boolean isAdmin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (role != null) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setRole(UserRole.Role role) {
        this.role = role;
    }

    public UserRole.Role getRole() {
        if (role != null) {
            return role;
        } else {
            throw new RuntimeException("Jogosultság nincs beállítva");
        }
    }

    public BookUser(NewUser newUser) {
        this.username = newUser.getUsername();
        this.password = newUser.getPassword();
        this.email = newUser.getEmail();

    }
}

