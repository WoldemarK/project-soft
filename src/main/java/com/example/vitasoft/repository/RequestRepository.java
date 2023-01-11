package com.example.vitasoft.repository;

import com.example.vitasoft.model.Request;
import com.example.vitasoft.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {
    List<Request> findAllByStatus(Status status);

    List<Request> findAllByRequestPerson_Id(Long id);

}
