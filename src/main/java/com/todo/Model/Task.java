package com.todo.Model;

import com.todo.Enums.Priority;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="Tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "title cannot be blank")
    @Size(max=255,message = "Title should not exceed 255 characters")
    private String title;

    @Column(length=500)
    private String description;
    private Boolean completed;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @CreationTimestamp
    private LocalDateTime createdAt;



}
