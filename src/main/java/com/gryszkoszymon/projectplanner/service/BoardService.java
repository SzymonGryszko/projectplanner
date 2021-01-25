package com.gryszkoszymon.projectplanner.service;

import com.gryszkoszymon.projectplanner.model.Board;
import com.gryszkoszymon.projectplanner.model.Column;
import com.gryszkoszymon.projectplanner.model.User;
import com.gryszkoszymon.projectplanner.repository.BoardRepository;
import com.gryszkoszymon.projectplanner.repository.UserRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Service
@AllArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;


    public Optional<Board> findBoardById(Long boardId) {
        return boardRepository.findById(boardId);
    }

    public List<Board> getAllBoardsPerUser(Long userID) throws NotFoundException {
        User user = userRepository.findById(userID).orElseThrow(() -> new NotFoundException("Could not find board for user id: : " + userID));
        return boardRepository.findAllByBoardMembersContains(user);
    }

    public Board getAllDataForBoard(Long boardID) throws NotFoundException {
        Board board = boardRepository.findById(boardID).orElseThrow(() -> new NotFoundException("Could not find board with id: " + boardID));
        return board;
    }

    public List<Column> createNewColumnForBoard(Long boardId) throws NotFoundException {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NotFoundException("Could not find board with id: " + boardId));
        Column column = new Column();
        column.setTitle("New Column");
        column.setTasks(new LinkedHashSet<>());
        board.getColumns().add(column);
        Board boardWithNewColumn = boardRepository.save(board);
        return boardWithNewColumn.getColumns();
    }
}
