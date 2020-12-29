package com.gryszkoszymon.projectplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String title;
    @OneToOne
    private Column column;
    @OneToMany(fetch = LAZY)
    private List<Comment> comments;
    private Instant startDate;
    private Instant dueDate;
    @OneToMany(fetch = LAZY)
    private List<User> assignedUsers;
    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;
    @OneToMany(fetch = LAZY)
    private List<CheckList> checkLists;

}
