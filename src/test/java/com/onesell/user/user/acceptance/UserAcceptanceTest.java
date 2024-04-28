package com.onesell.user.user.acceptance;

import static com.onesell.user.user.fixture.UserFixture.회원_수정_요청_픽스처;
import static com.onesell.user.user.fixture.UserFixture.회원가입_요청_픽스처;
import static com.onesell.user.user.step.UserStep.사용자가_회원가입함;
import static com.onesell.user.user.step.UserStep.회원_목록_조회_요청;
import static com.onesell.user.user.step.UserStep.회원_수정_요청;
import static com.onesell.user.user.step.UserStep.회원가입_요청;

import com.onesell.user.common.AcceptanceTest;
import com.onesell.user.user.dto.SortCondition;
import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.dto.UserModifyRequest;
import com.onesell.user.user.fixture.UserFixture;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.http.HttpStatus;

@DisplayName("회원 기능")
public class UserAcceptanceTest extends AcceptanceTest {

    @DisplayName("정상 회원가입")
    @Test
    void 회원가입() {
        // given
        UserJoinRequest 회원가입_요청_픽스처 = 회원가입_요청_픽스처();

        // when
        ExtractableResponse<Response> 회원가입_응답 = 회원가입_요청(회원가입_요청_픽스처);

        // then
        응답_코드_검증(회원가입_응답, HttpStatus.CREATED);
    }

    @DisplayName("필수값이 입력되지 않은 회원가입")
    @Test
    void 필수값이_입력되지않아_회원가입이_실패() {
        // given
        List<UserJoinRequest> 회원가입_필수값_누락_픽스처 = UserFixture.회원가입_요청_필수값_누락_픽스처();

        // when
        회원가입_필수값_누락_픽스처.forEach(
            픽스처 -> {
                ExtractableResponse<Response> 회원가입_응답 = 회원가입_요청(픽스처);

                // then
                응답_코드_검증(회원가입_응답, HttpStatus.BAD_REQUEST);
            }
        );
    }

    @DisplayName("이미 존재하는 ID가 입력된 회원가입")
    @Test
    void 이미_존재하는_ID_가입으로_회원가입_실패() {
        // given
        UserJoinRequest 회원가입_요청_픽스처 = 회원가입_요청_픽스처();
        ExtractableResponse<Response> 회원가입_응답 = 회원가입_요청(회원가입_요청_픽스처);
        응답_코드_검증(회원가입_응답, HttpStatus.CREATED);

        // when
        UserJoinRequest 회원가입_중복_ID_픽스처 = UserFixture.회원가입_중복_ID_픽스처();
        ExtractableResponse<Response> 중복_ID_회원가입_응답 = 회원가입_요청(회원가입_중복_ID_픽스처);

        // then
        응답_코드_검증(중복_ID_회원가입_응답, HttpStatus.CONFLICT);
    }

    @DisplayName("정상 회원수정")
    @Test
    void 회원수정() {
        // given
        UserJoinRequest 회원가입_요청_픽스처 = 회원가입_요청_픽스처();
        String 사용자_ID = 사용자가_회원가입함(회원가입_요청_픽스처);

        // when
        UserModifyRequest 회원_수정_요청_픽스처 = 회원_수정_요청_픽스처();
        ExtractableResponse<Response> 회원_수정_응답 = 회원_수정_요청(사용자_ID, 회원_수정_요청_픽스처);

        // then
        응답_코드_검증(회원_수정_응답, HttpStatus.OK);
    }

    @DisplayName("존재하지 않는 ID에 대한 회원 수정")
    @Test
    void 존재하지_않는_ID_수정으로_회원수정_실패() {
        // given
        UserModifyRequest 회원_수정_요청_픽스처 = 회원_수정_요청_픽스처();

        // when
        ExtractableResponse<Response> 회원_수정_응답 = 회원_수정_요청("ANY", 회원_수정_요청_픽스처);

        // then
        응답_코드_검증(회원_수정_응답, HttpStatus.NOT_FOUND);
    }

    @DisplayName("정상 회원목록조회")
    @ParameterizedTest
    @EnumSource(value = SortCondition.class)
    void 회원목록조회(SortCondition sort) {
        // given
        final int page = 0;
        final int size = 10;

        // when
        ExtractableResponse<Response> 회원_목록_조회_응답 = 회원_목록_조회_요청(page, size, sort);

        // then
        응답_코드_검증(회원_목록_조회_응답, HttpStatus.OK);
    }
}
