package com.example.vitasoft.service;

import com.example.vitasoft.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;

    private final RequestMapping requestMapping;
}
