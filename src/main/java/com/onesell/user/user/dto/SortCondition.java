package com.onesell.user.user.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SortCondition {

    NAME("name"),
    DATE("createdAt");

    private final String value;

    public String value() {
        return value;
    }
}
