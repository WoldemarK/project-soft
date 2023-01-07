package com.example.vitasoft.mapper;

import com.example.vitasoft.dto.RequestDto;
import com.example.vitasoft.dto.RequestDto;
import com.example.vitasoft.model.Request;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface RequestMapper {
    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "creation", target = "creation", dateFormat = "dd/MM/yyyy")
    RequestDto convertToRequestDto(Request request);

    @Mapping(source = "personId", target = "person.id")
    @Mapping(source = "creation", target = "creation", dateFormat = "dd/MM/yyyy")
    Request convertToRequest(RequestDto personDto);

    @Mapping(source = "personId", target = "person.id")
    @Mapping(source = "creation", target = "creation", dateFormat = "dd/MM/yyyy")
    void updateFromDto(RequestDto requestDto, @MappingTarget Request request);
}
