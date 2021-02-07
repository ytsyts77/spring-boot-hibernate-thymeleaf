package com.home.global.message;

public final class UserMessage {
    public static final String IS_REQUIRED = "%s 필수 입력값 입니다.";
    public static final String IS_NOT_FOUND = "%s 찾을 수 없습니다.";

    public static String get(String format, Object... args) {
        return String.format(format, args);
    }
}
