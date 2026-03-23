package com.example.Task_Manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Task_Manager.Model.task;

public interface TaskRepository extends JpaRepository<task, Long> {

	Object findByUsername(String username);

}