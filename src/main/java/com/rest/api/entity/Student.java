package com.rest.api.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Task> tasks = new ArrayList<>();

    public Student(String firstname, String lastname, int course) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.course = course;
    }

    public Student() {

    }

    public void createTask(Task task){
        tasks.add(task);
    }
}
