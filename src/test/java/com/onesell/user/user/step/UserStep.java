package com.onesell.user.user.step;

import static com.onesell.user.common.Step.*;

import com.onesell.user.common.AcceptanceTest;
import com.onesell.user.common.Step;
import com.onesell.user.user.dto.SortCondition;
import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.dto.UserModifyRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class UserStep extends Step {

    public static ExtractableResponse<Response> 회원가입_요청(final UserJoinRequest userJoinRequest) {
        return RestAssured
            .given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(userJoinRequest)
            .when().post("/api/user/join")
            .then().log().all()
            .extract();
    }

    public static String 사용자가_회원가입함(final UserJoinRequest userJoinRequest) {
        final ExtractableResponse<Response> response = 회원가입_요청(userJoinRequest);
        응답_코드_검증(response, HttpStatus.CREATED);
        return response.jsonPath().getString("data.userId");
    }

    public static ExtractableResponse<Response> 회원_수정_요청(final String userId,
        final UserModifyRequest userModifyRequest) {
        return RestAssured
            .given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(userModifyRequest)
            .when().patch("/api/user/" + userId)
            .then().log().all()
            .extract();
    }

    public static ExtractableResponse<Response> 회원_목록_조회_요청(final int page, final int size, final SortCondition sort) {
        return RestAssured
            .given().log().all()
            .queryParam("page", page)
            .queryParam("size", size)
            .queryParam("sort", sort)
            .when().get("/api/user/list")
            .then().log().all()
            .extract();
    }
}
