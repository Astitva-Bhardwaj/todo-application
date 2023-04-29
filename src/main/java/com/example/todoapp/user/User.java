package com.example.todoapp.user;

import com.example.todoapp.models.TodoItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    //@OneToMany
    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
    private List<TodoItem> tasks = new ArrayList<>();

    public void addToDoItem(TodoItem todoItem)
    {
        tasks.add(todoItem);
    }

}
