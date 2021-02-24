package com.gryszkoszymon.projectplanner.service;

import com.gryszkoszymon.projectplanner.exception.NotFoundException;
import com.gryszkoszymon.projectplanner.model.Column;
import com.gryszkoszymon.projectplanner.model.Task;
import com.gryszkoszymon.projectplanner.repository.ColumnRepository;
import com.gryszkoszymon.projectplanner.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ColumnService {

    private final ColumnRepository columnRepository;
    private final TaskRepository taskRepository;

    @Transactional
    public Set<Task> createNewTask(Long columnId, String taskTitle) throws NotFoundException {
        Column column = columnRepository.findById(columnId).orElseThrow(() -> new NotFoundException("Could not find column with id: " + columnId));
        Task newTask = new Task();
        newTask.setTitle(taskTitle);
        column.addTask(newTask);
        column.setColId(columnId);
        Column savedColumn = columnRepository.save(column);
        return savedColumn.getTasks();
    }

    public Set<Task> updateTasksSetAfterDrop(Long columnId, Set<Task> tasks) throws NotFoundException {
        Column column = columnRepository.findById(columnId).orElseThrow(() -> new NotFoundException("Could not find column with id: " + columnId));
        Set<Long> toBeDeleted = column.getTasks().stream().map(Task::getTaskId).collect(Collectors.toCollection(LinkedHashSet::new));
//        taskRepository.deleteTaskByTaskIdIn(toBeDeleted);
//        column.setTasks(tasks);
        return column.getTasks();

    }
}
