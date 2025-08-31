package com.todo.Repositiory;

import com.todo.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task,Long>{


}
