package com.gryszkoszymon.projectplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
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
    @OneToMany(fetch = EAGER, cascade = CascadeType.ALL)
    private Set<Task> tasks;

}
