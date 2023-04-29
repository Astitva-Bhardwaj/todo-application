package com.example.todoapp.user;

import com.example.todoapp.models.TodoItem;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public User createUser(User user);

    public User updateUser(Long id, User userDetails);

    public void deleteUser(Long id);

    public List<TodoItem> getUserTasks(Long id);

}
