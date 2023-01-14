package com.example.vitasoft.secyrity;

import com.example.vitasoft.model.Person;
import com.example.vitasoft.model.StatusRole;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@RequiredArgsConstructor
public class SecurityUser implements UserDetails {
    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromUser(Person person) {
        return new org.springframework.security.core.userdetails.User(
                person.getEmail(),
                person.getPassword(),
//                person.getStatusRole().equals(StatusRole.ACTIVE),
//                person.getStatusRole().equals(StatusRole.ACTIVE),
//                person.getStatusRole().equals(StatusRole.ACTIVE),
//                person.getStatusRole().equals(StatusRole.ACTIVE),
                person.getRoles().getAuthorities()

        );
    }
}
