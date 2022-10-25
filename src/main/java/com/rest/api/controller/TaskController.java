package com.rest.api.controller;

import com.rest.api.entity.Task;
import com.rest.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        return new ResponseEntity<>(taskService.getListTask(), HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }
}
