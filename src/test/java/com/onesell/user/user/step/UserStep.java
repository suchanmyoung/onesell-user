package com.onesell.user.user.step;

import com.onesell.user.user.dto.UserJoinRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class UserStep {

    public static ExtractableResponse<Response> 회원가입_요청(final UserJoinRequest userJoinRequest){
        return RestAssured
            .given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(userJoinRequest)
            .when().post("/api/user/join")
            .then().log().all()
            .extract();
    }
}
