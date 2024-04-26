package com.onesell.user.user.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserJoinRequest {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;

    @NotBlank
    private String nickname;

    @NotBlank
    private String name;

    @NotBlank
    private String cellphone;

    @NotBlank
    private String email;

}
