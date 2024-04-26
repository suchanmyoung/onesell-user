package com.onesell.user.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModifyRequest {

    private String password;

    private String nickname;

    private String name;

    private String cellphone;

    private String email;

}
