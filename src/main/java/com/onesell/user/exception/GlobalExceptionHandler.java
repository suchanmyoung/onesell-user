package com.onesell.user.exception;

import com.onesell.user.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(
        final MethodArgumentNotValidException e) {

        final String[] codes = e.getBindingResult().getFieldError().getCodes();
        final String message = e.getBindingResult().getFieldError().getDefaultMessage();

        log.warn("handleMethodArgumentNotValidException:: message={}" + message);
        ApiResponse apiResponse = ApiResponse.of(HttpStatus.BAD_REQUEST, message, codes);

        return ResponseEntity.status(apiResponse.getStatus())
            .body(apiResponse);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ApiResponse> handleBusinessException(final BusinessException e) {
        final ErrorCode errorCode = e.getErrorCode();

        log.warn("handleBusinessException:: message={}", errorCode.getMessage());
        ApiResponse apiResponse = ApiResponse.noData(errorCode.getStatus(), errorCode.getMessage());

        return ResponseEntity.status(apiResponse.getStatus())
            .body(apiResponse);
    }
}
