package com.onesell.user.common;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;

public class Step {

    protected static void 응답_코드_검증(final ExtractableResponse<Response> response, final HttpStatus status) {
        assertThat(response.statusCode()).isEqualTo(status.value());
    }
}
