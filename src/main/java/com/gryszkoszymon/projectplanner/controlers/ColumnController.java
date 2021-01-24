package com.gryszkoszymon.projectplanner.controlers;

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
    public Set<Task> createNewTask(@PathVariable long columnId, @RequestBody String taskTitle) {
        return columnService.createNewTask(columnId, taskTitle);
    }

}
