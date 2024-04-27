package com.onesell.user.common.response;

import org.springframework.http.ResponseEntity;

public class ResponseEntityWrapper {

    public static ResponseEntity<ApiResponse> from(final ApiResponse apiResponse) {
        return ResponseEntity.status(apiResponse.getStatus())
            .body(apiResponse);
    }

}
