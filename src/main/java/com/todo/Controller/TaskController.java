package com.todo.Controller;

import com.todo.Model.Task;
import com.todo.TaskService.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    public TaskService taskService;

    @PostMapping("/Create")
    public ResponseEntity<Task> CreateTask(@RequestBody Task task) {
        Task newTask = taskService.addTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @GetMapping("FindAll")
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> tasks = taskService.getAllTask();
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted Successfully");
    }

    @DeleteMapping("/DeleteAll")
    public ResponseEntity<String> deleteAllTask()
    {
        taskService.deleteAllTask();
        return ResponseEntity.ok("All tasks have been deleted Successfully");
    }

}
