package com.tms.springboottms.repository;

import com.tms.springboottms.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task, Long> {
}
