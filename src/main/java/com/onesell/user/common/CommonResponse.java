package com.onesell.user.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Builder
public class CommonResponse {

    private HttpStatus status;
    private String message;
    private Object data;

    public static CommonResponse of(final HttpStatus status, final Object data) {
        return CommonResponse.builder()
            .status(status)
            .data(data)
            .build();
    }

    public static CommonResponse of(final HttpStatus status, final String message,
        final Object data) {
        return CommonResponse.builder()
            .status(status)
            .message(message)
            .data(data)
            .build();
    }

    public static CommonResponse noData(final HttpStatus status, final String message) {
        return CommonResponse.builder()
            .status(status)
            .message(message)
            .build();
    }
}
