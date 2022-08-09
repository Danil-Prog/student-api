package com.rest.api.controller;


import com.rest.api.entity.Student;
import com.rest.api.exception.ResourceNotFoundException;
import com.rest.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentService.getListStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully!", HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
}
