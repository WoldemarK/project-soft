package com.example.vitasoft.model;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    OPERATOR,
   ADMINISTRATOR;

    @Override
    public String getAuthority() {
        return name();
    }

}
