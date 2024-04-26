package com.onesell.user.user.controller;

import com.onesell.user.common.response.ApiResponse;
import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.dto.UserModifyRequest;
import com.onesell.user.user.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    /**
     * 회원가입
     */
    @PostMapping("/join")
    public ResponseEntity<ApiResponse> join(@RequestBody @Valid final UserJoinRequest userJoinRequest) {
        final ApiResponse apiResponse = userService.join(userJoinRequest);
        return ResponseEntity.status(apiResponse.getStatus())
            .body(apiResponse);
    }

    /**
     * 회원수정
     */
    @PatchMapping("/{userId}")
    public ResponseEntity<ApiResponse> modify(@PathVariable final String userId, @RequestBody final UserModifyRequest userModifyRequest) {
        final ApiResponse apiResponse = userService.modify(userId, userModifyRequest);
        return ResponseEntity.status(apiResponse.getStatus())
            .body(apiResponse);
    }
}
