package com.onesell.user.exception;

import com.onesell.user.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponse handleMethodArgumentNotValidException(
        final MethodArgumentNotValidException e) {
        final String[] codes = e.getBindingResult().getFieldError().getCodes();
        final ErrorCode errorCode = ErrorCode.NOT_VALID_REQUEST_ERROR;
        log.warn("handleMethodArgumentNotValidException : " + e.getMessage());
        return ApiResponse.of(errorCode.getStatus(), errorCode.getMessage(), codes);
    }

    @ExceptionHandler(BusinessException.class)
    protected ApiResponse handleBusinessException(final BusinessException e) {
        final ErrorCode errorCode = e.getErrorCode();
        log.warn("handleBusinessException : " + e.getMessage());
        return ApiResponse.noData(errorCode.getStatus(), errorCode.getMessage());
    }
}
