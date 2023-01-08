package com.example.vitasoft.dto;

import com.example.vitasoft.model.Request;
import com.example.vitasoft.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
@Schema(description = "Сущность проекта инициатора")
public class PersonDto {
    @Schema(description = "Уникальный идентификатор заявки")
    private Long id;
    @Schema(description = "Имя инициатора заявки")
    private String name;
    @Schema(description = "Роль на портале")
    private Set<Role> roles;
    @Schema(description = "Заявки от инициатора")
    private List<Request> requests;
}
