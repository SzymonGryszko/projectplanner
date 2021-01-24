package com.gryszkoszymon.projectplanner.service;

import com.gryszkoszymon.projectplanner.model.*;
import com.gryszkoszymon.projectplanner.repository.BoardRepository;
import com.gryszkoszymon.projectplanner.repository.ColumnRepository;
import com.gryszkoszymon.projectplanner.repository.TaskRepository;
import com.gryszkoszymon.projectplanner.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.*;

@AllArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
//    private final TaskService taskService;
//    private final ColumnService columnService;
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    public Long setupUserAfterFirstLogin(String email, String name, String pictureURL, AuthProvider authProvider) {
        Task task = new Task();
        task.setTitle("Your first test");


        Column columnToDo = new Column();
        columnToDo.setTitle("To Do");
        columnToDo.setTasks(new LinkedHashSet<>(Arrays.asList(task)));

        Column columnInProgress = new Column();
        columnInProgress.setTitle("In Progress");
        columnInProgress.setTasks(new LinkedHashSet<>());

        Column columnDone = new Column();
        columnDone.setTitle("Done");
        columnDone.setTasks(new LinkedHashSet<>());


        Board board = new Board();
        board.setTitle("My Board");
        board.setColumns(new ArrayList<>(Arrays.asList(columnToDo, columnInProgress, columnDone)));

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setImageUrl(pictureURL);
        user.setCreated(Instant.now());
        user.setProvider(authProvider);
        user.setLastLoggedIn(Instant.now());

        board.setOwner(user);
        board.setBoardMembers(new ArrayList<>(Arrays.asList(user)));

        boardRepository.save(board);
        User savedUser = userRepository.save(user);

        return savedUser.getUserId();
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Long updateUserAfterLogin(User user, String name, String pictureUrl) {
        user.setLastLoggedIn(Instant.now());
        user.setImageUrl(pictureUrl);
        user.setName(name);

        User savedUser = userRepository.save(user);
        return savedUser.getUserId();
    }

    public User getUserInfoById(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) return userOptional.get();
    return null;

    }
}
