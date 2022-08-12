package com.rest.api.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "course")
    private int course;

    public Student(String firstname, String lastname, int course) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.course = course;
    }

    public Student() {

    }
}
