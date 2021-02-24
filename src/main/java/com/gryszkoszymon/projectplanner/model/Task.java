package com.gryszkoszymon.projectplanner.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long taskId;
    private String title;
    @OneToMany(fetch = LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;
    private Instant startDate;
    private Instant dueDate;
    @OneToMany(fetch = EAGER, cascade = CascadeType.ALL)
    private List<User> assignedUsers;
    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;
    @OneToMany(fetch = LAZY, cascade = CascadeType.ALL)
    private List<CheckList> checkLists;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "col_id")
    @JsonBackReference
    private Column parentCol;

    public Task(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task )) return false;
        return taskId != null && taskId.equals(((Task) o).getTaskId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
