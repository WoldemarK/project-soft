package com.example.vitasoft.service;

import com.example.vitasoft.dto.PersonDto;
import com.example.vitasoft.exception.AllException;
import com.example.vitasoft.mapper.PersonMapper;
import com.example.vitasoft.model.Person;

import com.example.vitasoft.repository.PersonRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonService {//implements UserDetailsService
    private final PersonRepository personRepository;
    private final PersonMapper mapper;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Person person = personRepository.findByEmail(username).orElseThrow(() ->
//                new UsernameNotFoundException("Пользователь не существует"));
//        return SecurityUser.fromUser(person);
//    }

    public Optional<List<PersonDto>> findAll() {
        List<Person> personList = personRepository.findAll();

        return Optional.ofNullable(Optional.of(personList.stream()
                        .map(mapper::convertToPersonDto)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new AllException(("Ошибка вызова, обратитесь к администратору"))));
    }

    public PersonDto assignOperaRightsToPerson(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(()->new AllException("Пользователь не найден"));
//        Set<Role> roles = new HashSet<>();
//        roles.add(person.getRole());
//        roles.add(Role.OPERATOR);
//        person.setRole(roles);
//        person = requestRepository.save(person);

        return mapper.convertToPersonDto(person);
    }

}
