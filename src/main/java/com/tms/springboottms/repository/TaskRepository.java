package com.tms.springboottms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.springboottms.entity.Task;

public interface TaskRepository  extends JpaRepository<Task, Long> {
}
