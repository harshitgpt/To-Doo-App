package com.todo.TaskService;

import com.todo.Model.Task;
import com.todo.Repositiory.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TaskRepository taskRepository;

    public Task addTask(Task task)
    {
        return taskRepository.save(task);
    }

    public List<Task> getAllTask()
    {
        return taskRepository.findAll();
    }

    public void deleteTask(long id)
    {
        if(!taskRepository.existsById(id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task with Id " + id + " Not found");
        }
        taskRepository.deleteById(id);
    }

    public void deleteAllTask()
    {
        taskRepository.deleteAll();
    }
}
