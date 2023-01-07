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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper mapper;

    public Optional<List<PersonDto>> findAll() {
        List<PersonDto> personDtos = new ArrayList<>();

        List<Person> personList = personRepository.findAll();

        for (Person person : personList) {
            PersonDto personDto = mapper.convertToPersonDto(person);
            personDtos.add(personDto);
        }
        return Optional.ofNullable(Optional.of(personDtos)
                .orElseThrow(() ->
                        new AllException("Ошибка вызова, обратитесь к администратору")));
    }

}
