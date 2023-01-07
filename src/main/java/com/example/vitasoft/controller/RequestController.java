package com.example.vitasoft.controller;

import com.example.vitasoft.controller.api.RequestControllerApi;
import com.example.vitasoft.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/request")
public class RequestController implements RequestControllerApi {
    private final RequestService requestService;

    @Override
    public String message() {
        return "null";
    }
}
