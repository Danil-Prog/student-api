package com.rest.api.service;


import com.rest.api.entity.Student;
import com.rest.api.entity.Task;
import com.rest.api.exception.ResourceNotFoundException;
import com.rest.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getListTask(){
        return taskRepository.findAll();
    }

    public Task getTaskById(long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isPresent())
            return task.get();
        else
            throw new ResourceNotFoundException("TaskRepository", "ID", id);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

}
