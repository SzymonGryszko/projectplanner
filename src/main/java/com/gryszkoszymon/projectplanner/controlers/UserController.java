package com.gryszkoszymon.projectplanner.controlers;

import com.gryszkoszymon.projectplanner.model.User;
import com.gryszkoszymon.projectplanner.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User getUserInfoById(@PathVariable long id) {
        return userService.getUserInfoById(id);
    }
}
