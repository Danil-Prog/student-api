package com.rest.api.service;


import com.rest.api.entity.Student;
import com.rest.api.exception.ResourceNotFoundException;
import com.rest.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getListStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent())
            return student.get();
        else
            throw new ResourceNotFoundException("StudentService", "ID", id);
    }

    public void deleteStudent(long id) {
        studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("StudentDelete", "ID", id));

        studentRepository.deleteById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

}
