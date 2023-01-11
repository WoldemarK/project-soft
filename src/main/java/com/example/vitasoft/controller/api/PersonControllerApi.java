package com.example.vitasoft.controller.api;

import com.example.vitasoft.dto.PersonDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequestMapping("/person")
@Tag(name = "Управление", description = "Администратор управляет правами доступа.")
public interface PersonControllerApi {
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('developers:write')")
    @Operation(summary = "Вывод ", description = "Позволяет вывести всех пользователей")
    Optional<List<PersonDto>> getAll();

    @PostMapping("/admin/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    @Operation(summary = "Добавление ", description = "Позволяет добавить пользователю роль оператора")
    ResponseEntity<PersonDto> addOperator(@Validated @PathVariable("id") Long id);
}
