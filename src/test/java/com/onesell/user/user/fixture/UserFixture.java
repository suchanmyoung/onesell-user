package com.onesell.user.user.fixture;

import com.onesell.user.user.dto.UserJoinRequest;
import java.util.Arrays;
import java.util.List;

public class UserFixture {

    public static UserJoinRequest 회원가입_요청_픽스처(){
        return UserJoinRequest.builder()
            .userId("ID")
            .password("PASSWORD")
            .nickname("NICKNAME")
            .email("EMAIL")
            .name("NAME")
            .cellphone("CELLPHONE")
            .build();
    }

    public static List<UserJoinRequest> 회원가입_필수값_누락_픽스처() {
        final UserJoinRequest ID_누락 = UserJoinRequest.builder()
            .password("PASSWORD")
            .nickname("NICKNAME")
            .email("EMAIL")
            .name("NAME")
            .cellphone("CELLPHONE")
            .build();

        final UserJoinRequest PASSWORD_누락 = UserJoinRequest.builder()
            .userId("ID")
            .nickname("NICKNAME")
            .email("EMAIL")
            .name("NAME")
            .cellphone("CELLPHONE")
            .build();

        final UserJoinRequest NICKNAME_누락 = UserJoinRequest.builder()
            .userId("ID")
            .password("PASSWORD")
            .email("EMAIL")
            .name("NAME")
            .cellphone("CELLPHONE")
            .build();

        final UserJoinRequest NAME_누락 = UserJoinRequest.builder()
            .userId("ID")
            .password("PASSWORD")
            .nickname("NICKNAME")
            .email("EMAIL")
            .cellphone("CELLPHONE")
            .build();

        final UserJoinRequest EMAIL_누락 = UserJoinRequest.builder()
            .userId("ID")
            .password("PASSWORD")
            .nickname("NICKNAME")
            .name("NAME")
            .cellphone("CELLPHONE")
            .build();

        final UserJoinRequest CELLPHONE_누락 = UserJoinRequest.builder()
            .userId("ID")
            .password("PASSWORD")
            .nickname("NICKNAME")
            .name("NAME")
            .email("EMAIL")
            .build();

        return Arrays.asList(ID_누락, PASSWORD_누락, NICKNAME_누락, EMAIL_누락, NAME_누락, CELLPHONE_누락);
    }
}
