package com.example.vitasoft.controller;

import com.example.vitasoft.controller.api.PersonControllerApi;
import com.example.vitasoft.dto.PersonDto;
import com.example.vitasoft.model.Person;
import com.example.vitasoft.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonController implements PersonControllerApi {
    private final PersonService personService;
    @Override
    public Optional<List<PersonDto>> getAll(){
        return personService.findAll();
    }


}