package com.onesell.user.user.controller;

import com.onesell.user.common.response.ApiResponse;
import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.service.UserService;
import javax.validation.Valid;
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
    public ApiResponse join(@RequestBody @Valid final UserJoinRequest userJoinRequest) {
        final ApiResponse apiResponse = userService.join(userJoinRequest);
        return apiResponse;
    }

}
