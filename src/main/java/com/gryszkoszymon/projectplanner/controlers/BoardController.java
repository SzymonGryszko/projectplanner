package com.gryszkoszymon.projectplanner.controlers;

import com.gryszkoszymon.projectplanner.model.Board;
import com.gryszkoszymon.projectplanner.model.Column;
import com.gryszkoszymon.projectplanner.service.BoardService;
import com.gryszkoszymon.projectplanner.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
public class BoardController {

    private final BoardService boardService;
    private final UserService userService;

    @GetMapping("boards/{userID}")
    public List<Board> getAllBoardsPerUser(@PathVariable Long userID){
        return boardService.getAllBoardsPerUser(userID);
    }

    @GetMapping("board/{boardID}")
    public Board getAllDataForBoard(@PathVariable Long boardID){
        return boardService.getAllDataForBoard(boardID);
    }

    @PostMapping("board/{boardId}/add-column")
    public List<Column> createNewColumn(@PathVariable long boardId) {
        return boardService.createNewColumnForBoard(boardId);
    }




}
