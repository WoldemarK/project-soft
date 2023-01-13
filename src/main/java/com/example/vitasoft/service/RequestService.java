package com.example.vitasoft.service;

import com.example.vitasoft.dto.RequestDto;
import com.example.vitasoft.exception.AllException;
import com.example.vitasoft.mapper.RequestMapper;
import com.example.vitasoft.model.Request;
import com.example.vitasoft.model.Status;
import com.example.vitasoft.repository.PersonRepository;
import com.example.vitasoft.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Log4j2
@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final PersonRepository personRepository;

    private final RequestMapper requestMapper;

    /**
     * Пользователь может создавать заявки
     *
     * @param requestDto
     * @return
     */
    public RequestDto createRequest(RequestDto requestDto) {
        Request request = requestMapper.convertToRequest(requestDto);
        request = requestRepository.save(request);
        return requestMapper.convertToRequestDto(request);
    }

    /**
     * Просмотр всех заявок созданные Person
     *
     * @param id
     * @return
     */
    public List<RequestDto> viewingApplications(Long id) {
        List<RequestDto> list = requestRepository.findByPerson(personRepository.findById(id).get());
        return new ArrayList<>(list);
    }

    /**
     * редактировать созданные им заявки в статусе «черновик»
     *
     * @param requestDto
     * @return
     */
    public RequestDto update(RequestDto requestDto) {
        if (requestDto.getStatus() == Status.DRAFT) {
            Request request = requestMapper.convertToRequest(requestDto);
            request = requestRepository.save(request);
            requestMapper.updateFromDto(requestDto, request);
        }
        return requestDto;
    }

    /**
     * Отправлять заявки на рассмотрение оператору.
     * @return
     */
    public RequestDto submitForReviewRequest(Long id){
      Request request = requestRepository.findById(id)
              .orElseThrow(()-> new AllException("submitForReviewRequest"));
        if (!(request ==null)){
            request.setStatus(Status.SENT);
            request = requestRepository.save(request);
        }
        return requestMapper.convertToRequestDto(request);
    }

}