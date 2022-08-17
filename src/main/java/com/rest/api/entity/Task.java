package com.rest.api.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    @Column(name = "header")
    private String header;

    @Column(name = "body")
    private String body;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "date_of_creation")
    @DateTimeFormat(pattern = "dd.MM.YYYY")
    private Date dateOfCreation = new Date();

    public Task() {
    }

    public Task(String header, String body, Student student) {
        this.header = header;
        this.body = body;
        this.student = student;
    }
}
