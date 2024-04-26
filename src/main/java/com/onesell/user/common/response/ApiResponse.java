package com.onesell.user.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ApiResponse {

    private HttpStatus status;
    private String message;
    private Object data;

    public static ApiResponse of(final HttpStatus status, final Object data) {
        return ApiResponse.builder()
            .status(status)
            .data(data)
            .build();
    }

    public static ApiResponse of(final HttpStatus status, final String message,
        final Object data) {
        return ApiResponse.builder()
            .status(status)
            .message(message)
            .data(data)
            .build();
    }

    public static ApiResponse noData(final HttpStatus status, final String message) {
        return ApiResponse.builder()
            .status(status)
            .message(message)
            .build();
    }
}
