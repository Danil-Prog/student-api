package com.rest.api.data;

import com.github.javafaker.Faker;
import com.rest.api.entity.Role;
import com.rest.api.entity.User;
import com.rest.api.service.UserService;
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
    private UserService userService;
    private final Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading Sample data...");

        //create 100 rows of student in the database
        List<User> users = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new User(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.internet().emailAddress(),
                        faker.random().nextInt(1,4),
                        Role.ROLE_STUDENT,
                        faker.internet().password()
                ))
                .collect(Collectors.toList());

        userService.saveListStudent(users);
    }

}
