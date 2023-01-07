package com.example.vitasoft.controller.api;

import com.example.vitasoft.dto.PersonDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequestMapping("/person")
@Tag(name = "Управление", description = "Пользователь посредством системы может " +
        "подавать заявки оператору на рассмотрение. Оператор может просматривать " +
        "пользовательские заявки и приниматьили отклонять их. Администратор управляет правами доступа.")
public interface PersonControllerApi {
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    Optional<List<PersonDto>> getAll();

}
