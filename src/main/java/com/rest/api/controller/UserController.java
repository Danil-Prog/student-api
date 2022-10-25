package com.rest.api.controller;


import com.rest.api.entity.User;
import com.rest.api.exception.ResourceNotFoundException;
import com.rest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllStudent(){
        return new ResponseEntity<>(userService.getListStudents(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getStudentById(@PathVariable Long id) {
        User user = userService.getStudentById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        try {
            userService.deleteStudent(id);
            return new ResponseEntity<>("Student deleted successfully!", HttpStatus.OK);
        }catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> addStudent(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveStudent(user), HttpStatus.CREATED);
    }
}
