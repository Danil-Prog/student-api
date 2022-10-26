package com.rest.api.service;


import com.rest.api.entity.Role;
import com.rest.api.entity.User;
import com.rest.api.exception.ResourceNotFoundException;
import com.rest.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public List<User> getListStudents(){
        return userRepository.findAll();
    }

    public User register(User user) {
        Role roleUser = Role.ROLE_STUDENT;

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleUser);

        User registerUser = userRepository.save(user);
        return registerUser;
    }

    public User getStudentById(long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Пользователя с таким ID не существует", "ID", id));
    }

    public void deleteStudent(long id) {
        userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Пользователя с таким ID не существует", "ID", id));

        userRepository.deleteById(id);
    }

    public User saveStudent(User user) {
        return userRepository.save(user);
    }

    public void saveListStudent(List<User> userList) {
        userRepository.saveAll(userList);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByEmail(username);
    }

}
