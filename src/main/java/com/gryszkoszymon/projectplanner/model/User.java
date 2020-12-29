package com.gryszkoszymon.projectplanner.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import java.time.Instant;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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

}
