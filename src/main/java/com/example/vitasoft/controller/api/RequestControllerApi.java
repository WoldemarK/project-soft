package com.example.vitasoft.controller.api;

import com.example.vitasoft.dto.RequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/request")
@Tag(name = "Управление заявками", description = "Создание, поиск, получение.")
public interface RequestControllerApi {


    @PostMapping("/")
   // @PreAuthorize("hasAuthority('developers:write')")
    @Operation(summary = "Пользователь ", description = "Может создавать заявки.")
    ResponseEntity<RequestDto>createRequest(@RequestBody RequestDto requestDto);
    @GetMapping("/{id}")
   // @PreAuthorize("hasAuthority('developers:read')")
    @Operation(summary = "Пользователь ", description = "Просмотр всех им созданных заявок.")
    ResponseEntity<List<RequestDto>> viewingApplications(@PathVariable("id") Long id);
    @PostMapping("/update")
   // @PreAuthorize("hasAuthority('developers:write')")
    @Operation(summary = "Пользователь ", description = "Редактировать созданные им заявки в статусе «черновик».")
    ResponseEntity<RequestDto> update(@RequestBody RequestDto requestDto);

    @GetMapping("/{id}/get")
  //  @PreAuthorize("hasAuthority('developers:read')")
    @Operation(summary = "Пользователь ", description = "Отправлять заявки на рассмотрение оператору.")
    ResponseEntity<RequestDto> submitForReviewRequest(@PathVariable Long id);

//    @GetMapping("/")
//    @Operation(summary = "Оператор", description = "Просматривать отправленные на рассмотрение  заявки.")
//    ResponseEntity<RequestDto> getAllRequestStatus();
//
//    @PostMapping("/")
//    @Operation(summary = "Оператор", description = "Принимать заявки.")
//    ResponseEntity<RequestDto>acceptApplications();
//
//    @PostMapping("/")
//    @Operation(summary = "Оператор", description = "Отклонять заявки.")
//    ResponseEntity<RequestDto>rejectApplications();
}
