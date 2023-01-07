package com.example.vitasoft.mapper;

import com.example.vitasoft.dto.PersonDto;
import com.example.vitasoft.model.Person;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.FIELD)
public interface PersonMapper {


    PersonDto convertToPersonDto(Person person);
    Person convertToPerson(PersonDto personDto);

    void updateFromDto(PersonDto personDto, @MappingTarget Person person);
}
