package com.gryszkoszymon.projectplanner.service;

import com.gryszkoszymon.projectplanner.exception.NotFoundException;
import com.gryszkoszymon.projectplanner.model.Column;
import com.gryszkoszymon.projectplanner.model.Task;
import com.gryszkoszymon.projectplanner.repository.ColumnRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional
public class ColumnService {

    private final ColumnRepository columnRepository;

    public Set<Task> createNewTask(long columnId, String taskTitle) throws NotFoundException {
        Column column = columnRepository.findById(columnId).orElseThrow(() -> new NotFoundException("Could not find column with id: " + columnId));
        Task newTask = new Task();
        newTask.setTitle(taskTitle);
        column.getTasks().add(newTask);
        Column savedColumn = columnRepository.save(column);
        return savedColumn.getTasks();
    }
}
