package com.gryszkoszymon.projectplanner.repository;

import com.gryszkoszymon.projectplanner.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {

}
