package com.gryszkoszymon.projectplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CheckListTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String taskDescription;
    @Enumerated(value = EnumType.STRING)
    private CheckListTaskStatus checkListTaskStatus;

}
