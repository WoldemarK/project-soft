package com.example.vitasoft.model;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Data
@Entity
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 25, nullable = false, unique = true)
    private String name;
    @Transient
    @Column(name = "password", length = 128, nullable = false, unique = true)
    private String password;
    @Column(name = "email")
    private String email;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Set<Role> role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    private Collection<Request> requests;



}
