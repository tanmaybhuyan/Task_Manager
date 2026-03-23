package com.example.Task_Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Task_Manager.TokenUtil;
import com.example.Task_Manager.Model.task;
import com.example.Task_Manager.Model.user;
import com.example.Task_Manager.Repository.TaskRepository;
import com.example.Task_Manager.Repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/Tasks")
public class AuthController { 

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TokenUtil tokenUtil;


    // ✅ CREATE NOTE
    @PostMapping
    public Object createTask(@RequestBody task T, @RequestHeader("Authorization") String token) {

        String username = tokenUtil.validateToken(token);

        if (username == null) {
            return "unauthorized";
        }

        T.setUsername(username);
        return taskRepo.save(T);
    }


    // ✅ GET USER TASKS
    @GetMapping
    public Object getTask(@RequestHeader("Authorization") String token) {

        String username = tokenUtil.validateToken(token);
        
        if (username == null) {
            return "Unauthorized";
        }

        return taskRepo.findByUsername(username);
    }

    
    // ✅ ADMIN API
    @GetMapping("/admin")
    public Object getAllTasks(@RequestHeader("Authorization") String token) {

        String username = tokenUtil.validateToken(token);

        if (username == null) {
            return "Unauthorized";
        }

        user user = userRepo.findByUsername(username);

        if (!user.getRole().equals("ADMIN")) {
            return "Access Denied";
        }

        return taskRepo.findAll();
    }
}