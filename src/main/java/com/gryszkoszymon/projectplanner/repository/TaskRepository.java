package com.gryszkoszymon.projectplanner.repository;

import com.gryszkoszymon.projectplanner.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TaskRepository extends JpaRepository<Task, Long> {
    void deleteTaskByTaskIdIn(Set<Long> ids);
}
