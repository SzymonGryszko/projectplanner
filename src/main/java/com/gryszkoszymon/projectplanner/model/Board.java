package com.gryszkoszymon.projectplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "board_col")
    private List<Column> columns;
    @OneToOne(fetch = EAGER, cascade = CascadeType.ALL)
    private User owner;
    @OneToMany(cascade = CascadeType.ALL, fetch = EAGER)
    @JoinColumn(name = "board_members")
    private List<User> boardMembers;

}
