package com.gryszkoszymon.projectplanner.service;

import com.gryszkoszymon.projectplanner.model.Board;
import com.gryszkoszymon.projectplanner.model.User;
import com.gryszkoszymon.projectplanner.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

//    public Board createNewBoard(String name) {
//        Board board = new Board();
//        board.setTitle(name);
//        board.setColumns(new ArrayList<>(Arrays.asList()));
////        board.setUsers(new ArrayList<>());
//        return boardRepository.save(board);
//    }

    public Optional<Board> findBoardById(Long boardId) {
        return boardRepository.findById(boardId);
    }

}
