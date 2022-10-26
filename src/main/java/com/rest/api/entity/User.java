package com.rest.api.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "course")
    private int course;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();

    public User(String firstname, String lastname, String email, int course, Role role, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.course = course;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public void createTask(Task task){
        tasks.add(task);
    }
}
