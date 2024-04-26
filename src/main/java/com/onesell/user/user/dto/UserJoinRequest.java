package com.onesell.user.user.dto;

import lombok.Getter;

@Getter
public class UserJoinRequest {

    private String userId;
    private String password;
    private String nickname;
    private String name;
    private String cellphone;
    private String email;

}
