package com.gryszkoszymon.projectplanner.repository;

import com.gryszkoszymon.projectplanner.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
