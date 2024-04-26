package com.onesell.user.user.controller;

import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public void join(@RequestBody UserJoinRequest userJoinRequest) {
        userService.join(userJoinRequest);
    }

}
