package com.onesell.user.common;

import com.onesell.user.common.encryptor.Sha256Encryptor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EncryptorTest {

    @Test
    void SHA256_암호화_테스트() {
        final Sha256Encryptor sha256Encryptor = new Sha256Encryptor();
        final String encryptPassword = sha256Encryptor.encrypt("password");

        final String preparedPassword = "c4f7ee590dac132e6ba712a2a238fcc904e4a70bf2479f1d1733dbd2bb1cafe2";
        Assertions.assertThat(encryptPassword).isEqualTo(preparedPassword);
    }
}
