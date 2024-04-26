package com.onesell.user.exception;

import com.onesell.user.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected CommonResponse handleBusinessException(final BusinessException e) {
        final ErrorCode errorCode = e.getErrorCode();
        log.warn("handleBusinessException : " + e.getMessage());
        return CommonResponse.noData(errorCode.getStatus(), errorCode.getMessage());
    }
}
