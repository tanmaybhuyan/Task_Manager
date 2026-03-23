package com.example.Task_Manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Task_Manager.Model.user;

public interface UserRepository extends JpaRepository{

    user findByUsername(String username);

}