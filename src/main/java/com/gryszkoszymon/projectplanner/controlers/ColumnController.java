package com.gryszkoszymon.projectplanner.controlers;

import com.gryszkoszymon.projectplanner.exception.NotFoundException;
import com.gryszkoszymon.projectplanner.model.Task;
import com.gryszkoszymon.projectplanner.service.ColumnService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
public class ColumnController {

    private final ColumnService columnService;

    @PostMapping("column/{columnId}/add-task")
    public Set<Task> createNewTask(@PathVariable Long columnId, @RequestBody String taskTitle) throws NotFoundException {
        return columnService.createNewTask(columnId, taskTitle);
    }

    @PostMapping("column/{columnId}/update-set")
    public Set<Task> updateTasksSetAfterDrop(@PathVariable Long columnId, @RequestBody Set<Task> tasks) throws NotFoundException {
        System.out.println("test " + columnId);
        return columnService.updateTasksSetAfterDrop(columnId, tasks);

    }

}
