package com.onesell.user.user.acceptance;

import static com.onesell.user.user.fixture.UserFixture.회원가입_요청_픽스처;
import static com.onesell.user.user.step.UserStep.회원가입_요청;
import static org.assertj.core.api.Assertions.assertThat;

import com.onesell.user.common.AcceptanceTest;
import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.fixture.UserFixture;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

@Transactional
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
        List<UserJoinRequest> 회원가입_필수값_누락_픽스처 = UserFixture.회원가입_필수값_누락_픽스처();

        // when
        회원가입_필수값_누락_픽스처.forEach(
            픽스처 -> {
                ExtractableResponse<Response> 회원가입_응답 = 회원가입_요청(픽스처);

                // then
                응답_코드_검증(회원가입_응답, HttpStatus.BAD_REQUEST);
            }
        );

    }

}
