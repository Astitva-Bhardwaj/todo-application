package com.example.todoapp.admin;

import com.example.todoapp.models.TodoItem;
import com.example.todoapp.services.TodoItemService;
import com.example.todoapp.user.User;
import com.example.todoapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @GetMapping("/{username}/users")
    public List<User> getAllUsers(@PathVariable String username)
    {
        Admin admin = adminService.findByUsername(username);
        if(admin == null)
        {
            throw new RuntimeException("Admin not found");
        }
        return userService.getAllUsers();
    }

    @GetMapping("/{username}/users/{id}/tasks")
    public List<TodoItem> getUserTasks(@PathVariable String username, @PathVariable Long id)
    {
        Admin admin  = adminService.findByUsername(username);
        if(admin == null)
        {
            throw new RuntimeException("Admin not found");
        }

        return userService.getUserTasks(id);
    }
}
