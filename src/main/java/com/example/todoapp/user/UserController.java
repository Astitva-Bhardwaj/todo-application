package com.example.todoapp.user;

import com.example.todoapp.models.TodoItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers()
    {
        log.info("UserController -- getAllUsers");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}/tasks")
    public List<TodoItem> getUserTasks(@PathVariable Long id)
    {
        return userService.getUserTasks(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user)
    {
        log.info("UserController -- saveUser");
        return userService.createUser(user);
    }


}
