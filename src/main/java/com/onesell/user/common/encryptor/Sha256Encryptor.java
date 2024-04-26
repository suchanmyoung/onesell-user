package com.onesell.user.common.encryptor;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;

@Service
public class Sha256Encryptor implements Encryptor {

    @Override
    public String encrypt(final String originalString) {
        final String saltedString = originalString + Salt.SALT.getKey();

        return Hashing.sha256()
            .hashString(saltedString, StandardCharsets.UTF_8)
            .toString();
    }
}
