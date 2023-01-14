package com.example.vitasoft.repository;

import com.example.vitasoft.dto.RequestDto;
import com.example.vitasoft.model.Person;
import com.example.vitasoft.model.Request;

import com.example.vitasoft.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {

    List<RequestDto> findByPerson(Person person);


    List<Request> findAllByStatus(Status sent);
}
