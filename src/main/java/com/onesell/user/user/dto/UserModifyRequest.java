package com.onesell.user.user.dto;

import com.onesell.user.common.pattern.Regex;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModifyRequest {

    @Length(min = 8, message = "비밀번호는 8자 이상이어야 합니다.")
    @Length(max = 25, message = "비밀번호는 25자 이하이어야 합니다.")
    @Pattern(regexp = Regex.ONLY_ENG_AND_NUMBER_AND_SPECIAL, message = "비밀번호는 영문,숫자,특수문자 조합만 가능합니다.")
    private String password;

    @Length(max = 10, message = "닉네임은 10자 이하이어야 합니다.")
    private String nickname;

    @Length(min = 2, message = "이름은 2자 이상이어야 합니다.")
    @Length(max = 10, message = "이름은 10자 이하이어야 합니다.")
    private String name;

    @Pattern(regexp = Regex.CELL_PHONE, message = "휴대폰 번호를 확인해주세요.")
    private String cellphone;

    @Length(min = 8, message = "이메일은 8자 이상이어야 합니다.")
    @Length(max = 25, message = "이메일은 25자 이하이어야 합니다.")
    @Pattern(regexp = Regex.EMAIL, message = "이메일 형식을 지켜주세요.")
    private String email;

}
