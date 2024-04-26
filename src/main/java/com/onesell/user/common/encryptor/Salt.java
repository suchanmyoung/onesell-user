package com.onesell.user.common.encryptor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Salt {

    SALT("onesell");

    private String key;

}
