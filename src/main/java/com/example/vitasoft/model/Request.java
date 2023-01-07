package com.example.vitasoft.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "header", length = 50, nullable = false)
    private String header;
    @Column(name = "description", length = 5000, nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person person;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime creation;


}
