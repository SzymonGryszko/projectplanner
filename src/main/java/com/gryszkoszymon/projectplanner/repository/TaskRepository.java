package com.gryszkoszymon.projectplanner.repository;

import com.gryszkoszymon.projectplanner.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    void deleteTaskByTaskIdIn(List<Long> id);
}
