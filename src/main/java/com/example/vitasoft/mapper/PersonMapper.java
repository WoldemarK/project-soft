package com.example.vitasoft.mapper;

import com.example.vitasoft.dto.PersonDto;
import com.example.vitasoft.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto convertToPersonDto(Person person);
    Person convertToPerson(PersonDto personDto);

    void updateFromDto(PersonDto personDto, @MappingTarget Person person);
}
