package com.onesell.user.user.controller;

import com.onesell.user.common.response.ApiResponse;
import com.onesell.user.common.response.ResponseEntityWrapper;
import com.onesell.user.user.dto.SortCondition;
import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.dto.UserModifyRequest;
import com.onesell.user.user.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ApiResponse> join(
        @RequestBody @Valid final UserJoinRequest userJoinRequest) {
        final ApiResponse apiResponse = userService.join(userJoinRequest);
        return ResponseEntityWrapper.from(apiResponse);
    }

    /**
     * 회원목록조회
     */
    @GetMapping("/list")
    public ResponseEntity<ApiResponse> getUsers(@RequestParam("page") final int page,
        @RequestParam("size") final int size, @RequestParam("sort") final SortCondition sort) {
        final PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort.value()).descending());
        final ApiResponse apiResponse = userService.getUsers(pageRequest);
        return ResponseEntityWrapper.from(apiResponse);
    }

    /**
     * 회원수정
     */
    @PatchMapping("/{userId}")
    public ResponseEntity<ApiResponse> modify(@PathVariable @Valid final String userId,
        @RequestBody final UserModifyRequest userModifyRequest) {
        final ApiResponse apiResponse = userService.modify(userId, userModifyRequest);
        return ResponseEntityWrapper.from(apiResponse);
    }
}
