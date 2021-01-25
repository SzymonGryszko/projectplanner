package com.gryszkoszymon.projectplanner.controlers;

import com.gryszkoszymon.projectplanner.model.Board;
import com.gryszkoszymon.projectplanner.model.Column;
import com.gryszkoszymon.projectplanner.service.BoardService;
import com.gryszkoszymon.projectplanner.service.UserService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("boards/{userID}")
    public List<Board> getAllBoardsPerUser(@PathVariable Long userID) throws NotFoundException {
        return boardService.getAllBoardsPerUser(userID);
    }

    @GetMapping("board/{boardID}")
    public Board getAllDataForBoard(@PathVariable Long boardID) throws NotFoundException {
        return boardService.getAllDataForBoard(boardID);
    }

    @PostMapping("board/{boardId}/add-column")
    public List<Column> createNewColumn(@PathVariable long boardId) throws NotFoundException {
        return boardService.createNewColumnForBoard(boardId);
    }




}
