package com.gryszkoszymon.projectplanner.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "col")
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ColId;
    private String title;
    @OneToMany(mappedBy = "parentCol", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Task> tasks = new LinkedHashSet<>();

    public void addTask(Task task) {
        tasks.add(task);
        task.setParentCol(this);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        task.setParentCol(null);
    }

}
