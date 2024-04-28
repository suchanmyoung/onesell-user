package com.onesell.user.user.fixture;

import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.dto.UserModifyRequest;
import java.util.Arrays;
import java.util.List;

public class UserFixture {

    public static UserJoinRequest 회원가입_요청_픽스처(){
        return UserJoinRequest.builder()
            .userId("ID001")
            .password("PASSWORD001")
            .nickname("NICKNAME")
            .email("EMAIL@google.com")
            .name("NAME")
            .cellphone("010-0000-0000")
            .build();
    }

    public static List<UserJoinRequest> 회원가입_요청_필수값_누락_픽스처() {
        final UserJoinRequest ID_누락 = UserJoinRequest.builder()
            .password("PASSWORD001")
            .nickname("NICKNAME")
            .email("EMAIL@google.com")
            .name("NAME")
            .cellphone("010-0000-0000")
            .build();

        final UserJoinRequest PASSWORD_누락 = UserJoinRequest.builder()
            .userId("ID001")
            .nickname("NICKNAME")
            .email("EMAIL@google.com")
            .name("NAME")
            .cellphone("010-0000-0000")
            .build();

        final UserJoinRequest NICKNAME_누락 = UserJoinRequest.builder()
            .userId("ID001")
            .password("PASSWORD001")
            .email("EMAIL@google.com")
            .name("NAME")
            .cellphone("010-0000-0000")
            .build();

        final UserJoinRequest NAME_누락 = UserJoinRequest.builder()
            .userId("ID001")
            .password("PASSWORD001")
            .nickname("NICKNAME")
            .email("EMAIL@google.com")
            .cellphone("010-0000-0000")
            .build();

        final UserJoinRequest EMAIL_누락 = UserJoinRequest.builder()
            .userId("ID001")
            .password("PASSWORD001")
            .nickname("NICKNAME")
            .name("NAME")
            .cellphone("010-0000-0000")
            .build();

        final UserJoinRequest CELLPHONE_누락 = UserJoinRequest.builder()
            .userId("ID001")
            .password("PASSWORD001")
            .nickname("NICKNAME")
            .email("EMAIL@google.com")
            .name("NAME")
            .build();

        return Arrays.asList(ID_누락, PASSWORD_누락, NICKNAME_누락, EMAIL_누락, NAME_누락, CELLPHONE_누락);
    }

    public static UserJoinRequest 회원가입_중복_ID_픽스처() {
        return UserJoinRequest.builder()
            .userId("ID001")
            .password("PASSWORD001")
            .nickname("NICKNAME")
            .email("EMAIL@google.com")
            .name("NAME")
            .cellphone("010-0000-0000")
            .build();
    }

    public static UserModifyRequest 회원_수정_요청_픽스처() {
        return UserModifyRequest.builder()
            .password("MODIFY_PASSWORD")
            .nickname("MODIFY_N")
            .email("MODIFY@google.com")
            .name("MODIFY")
            .cellphone("010-0000-1111")
            .build();
    }
}
