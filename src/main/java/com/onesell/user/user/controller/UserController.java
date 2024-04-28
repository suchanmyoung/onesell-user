package com.onesell.user.user.controller;

import com.onesell.user.common.response.ApiResponse;
import com.onesell.user.common.response.ResponseEntityWrapper;
import com.onesell.user.user.dto.SortCondition;
import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.dto.UserModifyRequest;
import com.onesell.user.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "회원 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입")
    @PostMapping("/join")
    public ResponseEntity<ApiResponse> join(
        @RequestBody @Valid final UserJoinRequest userJoinRequest) {
        final ApiResponse apiResponse = userService.join(userJoinRequest);
        return ResponseEntityWrapper.from(apiResponse);
    }


    @Operation(summary = "회원목록조회")
    @GetMapping("/list")
    public ResponseEntity<ApiResponse> getUsers(
        @Parameter(description = "페이지번호", example = "0")
        @RequestParam("page") final int page,
        @Parameter(description = "사이즈", example = "10")
        @RequestParam("size") final int size,
        @Parameter(description = "정렬조건", example = "DATE")
        @RequestParam("sort") final SortCondition sort) {
        final PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort.value()).descending());
        final ApiResponse apiResponse = userService.getUsers(pageRequest);
        return ResponseEntityWrapper.from(apiResponse);
    }


    @Operation(summary = "회원수정", description = "요청 시 NULL 혹은 제외한 속성은 변경되지 않음")
    @PatchMapping("/{userId}")
    public ResponseEntity<ApiResponse> modify(
        @Parameter(description = "수정할 사용자 아이디", example = "ID001")
        @PathVariable final String userId,
        @RequestBody @Valid final UserModifyRequest userModifyRequest) {
        final ApiResponse apiResponse = userService.modify(userId, userModifyRequest);
        return ResponseEntityWrapper.from(apiResponse);
    }
}
