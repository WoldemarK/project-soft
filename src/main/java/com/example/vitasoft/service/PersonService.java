package com.example.vitasoft.service;

import com.example.vitasoft.dto.PersonDto;
import com.example.vitasoft.exception.AllException;
import com.example.vitasoft.mapper.PersonMapper;
import com.example.vitasoft.model.Person;
import com.example.vitasoft.model.Role;
import com.example.vitasoft.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper mapper;

    public Optional<List<PersonDto>> findAll() {

        List<Person> personList = personRepository.findAll();

        return Optional.ofNullable(Optional.of(personList.stream()
                        .map(mapper::convertToPersonDto)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new AllException(("Ошибка вызова, обратитесь к администратору"))));
    }

    public Optional<PersonDto> addOperator(Long id) {

        Optional<Person> person = personRepository.findById(id);

        if (person.isEmpty()){
            throw new AllException("Человека с " + id + " не найден");
        }
        List<Role>roles =  person.get().getRoles();
        roles.add(Role.OPERATOR);

        person.get().setRoles(roles);
        Person save = personRepository.save(person.get());

        return Optional.ofNullable(mapper.convertToPersonDto(save));
    }

}
