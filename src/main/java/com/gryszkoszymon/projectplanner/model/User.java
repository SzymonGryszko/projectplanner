package com.gryszkoszymon.projectplanner.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NonNull
    private String name;
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    private String imageUrl;
    private Instant created;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;
    private Instant lastLoggedIn;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "owner_board")
//    private List<Board> boardsAsCreator;
//    @ManyToMany(cascade = CascadeType.ALL, fetch = EAGER)
//    private List<Board> boardsUserIsAssignedTo;

}
