package com.example.vitasoft.dto;

import com.example.vitasoft.model.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Сущность проекта заявки")
public class RequestDto {
    @Schema(description = "Уникальный идентификатор заявки")
    private Long id;
    @Schema(description = "Заголовок")
    private String header;
    @Schema(description = "Описание проблемы")
    private String description;
    @Schema(description = "Статус заявки")
    private Status status;
    @Schema(description = "ID Person")
    private long personId;
    @Schema(description = "Дата  создания заявки")
    private LocalDateTime creation;
}
