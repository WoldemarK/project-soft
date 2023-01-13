package com.example.vitasoft.controller.api;

import com.example.vitasoft.dto.RequestDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/request")
@Tag(name = "Управление заявками", description = "Создание, поиск, получение")
public interface RequestControllerApi {


    @PostMapping("/")
    @PreAuthorize("hasAuthority('developers:write')")
    ResponseEntity<RequestDto>createRequest(@RequestBody RequestDto requestDto);
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    ResponseEntity<List<RequestDto>> viewingApplications(@PathVariable("id") Long id);
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('developers:write')")
    ResponseEntity<RequestDto> update(@RequestBody RequestDto requestDto);

    @GetMapping("/{id}/get")
    @PreAuthorize("hasAuthority('developers:read')")
    ResponseEntity<RequestDto> submitForReviewRequest(@PathVariable Long id);
}
