package com.example.vitasoft.controller;

import com.example.vitasoft.controller.api.PersonControllerApi;
import com.example.vitasoft.dto.PersonDto;
import com.example.vitasoft.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonController implements PersonControllerApi {
    private final PersonService personService;
    @Override
    public Optional<List<PersonDto>> getAll(){
        return ResponseEntity.ok(personService.findAll()).getBody();
    }

    @Override
    public ResponseEntity<PersonDto> addOperator(Long id) {
        PersonDto person = personService.assignOperaRightsToPerson(id);
        return ResponseEntity.ok(person);
    }


}