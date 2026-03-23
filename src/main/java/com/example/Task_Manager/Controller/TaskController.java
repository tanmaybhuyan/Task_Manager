package com.example.Task_Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Task_Manager.TokenUtil;
import com.example.Task_Manager.Model.user;
import com.example.Task_Manager.Model.user;
import com.example.Task_Manager.Repository.TaskRepository;
import com.example.Task_Manager.Repository.UserRepository;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/auth")
public class TaskController{
	@Autowired 
	private UserRepository repo;
	@Autowired
	private TokenUtil tokenUtil;
	@Autowired
	private TaskRepository noteRepo;
	 @PostMapping("/register")
	    public String register(@RequestBody user u) {
	        repo.save(u);
	        return "Registered";
	    }
	 @PostMapping("/login")
	    public String login(@RequestBody user u) {

	        user dbUser=repo.findByUsername(u.getUsername());
	        if (dbUser != null && dbUser.getPassword().equals(u.getPassword())){
 
	            return tokenUtil.generateToken(u.getUsername());
	        }

	        return "Invalid credentials";
	    }
	}