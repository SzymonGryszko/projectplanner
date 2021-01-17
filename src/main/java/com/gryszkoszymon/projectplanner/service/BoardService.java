package com.gryszkoszymon.projectplanner.service;

import com.gryszkoszymon.projectplanner.model.Board;
import com.gryszkoszymon.projectplanner.model.User;
import com.gryszkoszymon.projectplanner.repository.BoardRepository;
import com.gryszkoszymon.projectplanner.repository.UserRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
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

    public List<Board> getAllBoardsPerUser(Long userID) {
        Optional<User> userOptional = userRepository.findById(userID);
        if (userOptional.isPresent()) {
            return boardRepository.findAllByBoardMembersContains(userOptional.get());
        }
        return null;
    }

    public Board getAllDataForBoard(Long boardID) {
        Optional<Board> boardOptional = boardRepository.findById(boardID);
        if (boardOptional.isPresent()) {
            return boardOptional.get();
        }
        return null;
    }
}
