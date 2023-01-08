package com.example.vitasoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "person")
public class Person implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 25, nullable = false, unique = true)
    private String name;

    @Column(name = "password", length = 128, nullable = false, unique = true)
    private String password;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "role_person", joinColumns = @JoinColumn(name = "person_id"),
//    inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    private List<Request> requests;

//###############################################################################################

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
        //Collections.singleton(new SimpleGrantedAuthority(authority.getAuthority()))
    }

    @Override
    public String getUsername() {
        return name;
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
}
