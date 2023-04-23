package com.example.todoapp.repositories;


//import com.example.springboot3todoapplication.models.TodoItem;
import com.example.todoapp.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
