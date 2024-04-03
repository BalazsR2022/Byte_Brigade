package com.geolidth.BackEnd.models;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_GUEST;

    @Override
    public String getAuthority() {
        return name();
    }

    public void setId(Integer id) {
        // Az azonosító beállítása
    }

    public Integer getId() {
        // Az azonosító lekérése
        return null;
    }
}
