package com.onesell.common;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.onesell.user.common.pattern.Regex;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegexTest {

    @DisplayName("정규식이 영문과 숫자만 입력 가능한지 확인")
    @Test
    void 영문과_숫자만_입력가능() {
        String 영문과_숫자만_입력가능한_정규식 = Regex.ONLY_ENG_AND_NUMBER;

        assertAll(
            () -> assertEquals(Pattern.matches(영문과_숫자만_입력가능한_정규식, "ID001"), true),
            () -> assertEquals(Pattern.matches(영문과_숫자만_입력가능한_정규식, "IDEA"), true),
            () -> assertEquals(Pattern.matches(영문과_숫자만_입력가능한_정규식, "0001"), true),
            () -> assertEquals(Pattern.matches(영문과_숫자만_입력가능한_정규식, "001id"), true),
            () -> assertEquals(Pattern.matches(영문과_숫자만_입력가능한_정규식, "ID001#"), false),
            () -> assertEquals(Pattern.matches(영문과_숫자만_입력가능한_정규식, "ID한글"), false)
        );
    }

    @DisplayName("정규식이 영문과 숫자, 특수문자만 입력 가능한지 확인")
    @Test
    void 영문과_숫자_특수문자만_입력가능() {
        String 영문과_숫자_특수문자만_입력가능한_정규식 = Regex.ONLY_ENG_AND_NUMBER_AND_SPECIAL;

        assertAll(
            () -> assertEquals(Pattern.matches(영문과_숫자_특수문자만_입력가능한_정규식, "PASSWORD001"), true),
            () -> assertEquals(Pattern.matches(영문과_숫자_특수문자만_입력가능한_정규식, "PASSWORD"), true),
            () -> assertEquals(Pattern.matches(영문과_숫자_특수문자만_입력가능한_정규식, "00000001"), true),
            () -> assertEquals(Pattern.matches(영문과_숫자_특수문자만_입력가능한_정규식, "PASSWORD001#"), true),
            () -> assertEquals(Pattern.matches(영문과_숫자_특수문자만_입력가능한_정규식, "!@#$%^&*"), true),
            () -> assertEquals(Pattern.matches(영문과_숫자_특수문자만_입력가능한_정규식, "비밀번호"), false),
            () -> assertEquals(Pattern.matches(영문과_숫자_특수문자만_입력가능한_정규식, "비밀번호001"), false),
            () -> assertEquals(Pattern.matches(영문과_숫자_특수문자만_입력가능한_정규식, "비밀번호001#"), false)
        );
    }

    @DisplayName("정규식이 한국 휴대폰 번호 형식으로만 입력 가능한지 확인")
    @Test
    void 한국_휴대폰_번호_형식으로만_입력가능() {
        String 한국_휴대폰_번호_형식으로만_입력가능한_정규식 = Regex.CELL_PHONE;

        assertAll(
            () -> assertEquals(Pattern.matches(한국_휴대폰_번호_형식으로만_입력가능한_정규식, "010-0000-0000"), true),
            () -> assertEquals(Pattern.matches(한국_휴대폰_번호_형식으로만_입력가능한_정규식, "011-0000-0000"), true),
            () -> assertEquals(Pattern.matches(한국_휴대폰_번호_형식으로만_입력가능한_정규식, "0110-0000-0000"), false),
            () -> assertEquals(Pattern.matches(한국_휴대폰_번호_형식으로만_입력가능한_정규식, "000-0000-0000"), false),
            () -> assertEquals(Pattern.matches(한국_휴대폰_번호_형식으로만_입력가능한_정규식, "010-000-000"), false),
            () -> assertEquals(Pattern.matches(한국_휴대폰_번호_형식으로만_입력가능한_정규식, "CELLPHONE"), false),
            () -> assertEquals(Pattern.matches(한국_휴대폰_번호_형식으로만_입력가능한_정규식, "01000000000"), false),
            () -> assertEquals(Pattern.matches(한국_휴대폰_번호_형식으로만_입력가능한_정규식, "010-####-####"), false)
            );
    }

    @DisplayName("정규식이 이메일 형식으로만 입력 가능한지 확인")
    @Test
    void 이메일_형식으로만_입력가능() {
        String 이메일_형식으로만_입력가능한_정규식 = Regex.EMAIL;

        assertAll(
            () -> assertEquals(Pattern.matches(이메일_형식으로만_입력가능한_정규식, "ID@google.com"), true),
            () -> assertEquals(Pattern.matches(이메일_형식으로만_입력가능한_정규식, "ID@google.123"), false),
            () -> assertEquals(Pattern.matches(이메일_형식으로만_입력가능한_정규식, "ID@googlecom"), false),
            () -> assertEquals(Pattern.matches(이메일_형식으로만_입력가능한_정규식, "google.com"), false)
        );

    }
}
