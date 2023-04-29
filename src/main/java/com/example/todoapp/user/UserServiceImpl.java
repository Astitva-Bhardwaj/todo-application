package com.example.todoapp.user;

import com.example.todoapp.models.TodoItem;
import com.example.todoapp.repositories.TodoItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public List<User> getAllUsers() {
        log.info("UserServiceImpl -- getAllUsers");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public User createUser(User user) {
        log.info("UserServiceImpl -- createUser");
        return userRepository.save(user);
//        User toBeSaved = new User();
//        List<TodoItem> todoItem = user.getTasks();
//        toBeSaved.setId(user.getId());
//        toBeSaved.setName(user.getName());
//        toBeSaved.setEmail(user.getEmail());
//        toBeSaved.setTasks(todoItem);
//        User saved = userRepository.save(toBeSaved);
//
//        for(TodoItem i:todoItem)
//        {
//            todoItemRepository.save(i);
//        }
//        return saved;
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<TodoItem> getUserTasks(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return user.getTasks();
    }
}
