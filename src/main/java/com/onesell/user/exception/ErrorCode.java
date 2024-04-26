package com.onesell.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_VALID_REQUEST_ERROR(HttpStatus.BAD_REQUEST, "잘못된 값이 입력되었습니다."),
    DUPLICATE_USER_ID(HttpStatus.CONFLICT, "이미 존재하는 회원 아이디입니다.");

    private final HttpStatus status;
    private final String message;

}
