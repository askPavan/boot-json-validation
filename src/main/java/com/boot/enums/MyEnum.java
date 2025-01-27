package com.boot.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MyEnum {
    VALUE1, VALUE2, VALUE3;

    @JsonCreator
    public static MyEnum fromString(String value) {
        try {
            return MyEnum.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;  // Return null for invalid values
        }
    }
}
