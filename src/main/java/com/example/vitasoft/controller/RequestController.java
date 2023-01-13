package com.example.vitasoft.controller;

import com.example.vitasoft.controller.api.RequestControllerApi;
import com.example.vitasoft.dto.RequestDto;
import com.example.vitasoft.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/request")
public class RequestController implements RequestControllerApi {
    private final RequestService requestService;

    @Override
    public ResponseEntity<RequestDto> createRequest(RequestDto requestDto) {
        return ResponseEntity.ok(requestService.createRequest(requestDto));
    }

    @Override
    public ResponseEntity<List<RequestDto>> viewingApplications(Long id) {
        return ResponseEntity.ok(requestService.viewingApplications(id));
    }

    @Override
    public ResponseEntity<RequestDto> update(RequestDto requestDto) {
        return ResponseEntity.ok(requestService.update(requestDto));
    }

    @Override
    public ResponseEntity<RequestDto> submitForReviewRequest(Long id) {
        return ResponseEntity.ok(requestService.submitForReviewRequest(id));
    }


}
