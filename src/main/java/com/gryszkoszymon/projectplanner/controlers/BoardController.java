package com.gryszkoszymon.projectplanner.controlers;

import com.gryszkoszymon.projectplanner.model.Board;
import com.gryszkoszymon.projectplanner.service.BoardService;
import com.gryszkoszymon.projectplanner.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;
    private final UserService userService;

    @GetMapping("/{userID}")
    public List<Board> getAllBoardsPerUser(@PathVariable Long userID){
//        return boardService.getAllBoardsPerUser(userID);
        return boardService.getAllBoardsPerUser(userID);

    }

}
