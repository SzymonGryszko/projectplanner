package com.gryszkoszymon.projectplanner.repository;

import com.gryszkoszymon.projectplanner.model.Board;
import com.gryszkoszymon.projectplanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByBoardMembersContains(User user);

}
