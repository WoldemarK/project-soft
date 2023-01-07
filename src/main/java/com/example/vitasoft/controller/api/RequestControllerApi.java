package com.example.vitasoft.controller.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/request")
@Tag(name = "Управление заявками", description = "Создание, поиск, получение")
public interface RequestControllerApi {
    @GetMapping
    String message();
}
