package com.rest.api.data;

import com.github.javafaker.Faker;
import com.rest.api.entity.Student;
import com.rest.api.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Slf4j
public class SampleDataLoader implements CommandLineRunner {

    @Autowired
    private StudentService studentService;
    private final Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading Sample data...");

        //create 100 rows of student in the database
        List<Student> students = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Student(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.random().nextInt(1,4)
                ))
                .collect(Collectors.toList());

        studentService.saveListStudent(students);
    }

}
