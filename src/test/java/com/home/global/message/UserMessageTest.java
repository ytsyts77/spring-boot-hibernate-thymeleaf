package com.home.global.message;

import org.junit.jupiter.api.Test;

import static com.home.global.message.UserMessage.IS_NOT_FOUND;
import static com.home.global.message.UserMessage.IS_REQUIRED;
import static org.junit.jupiter.api.Assertions.*;

class UserMessageTest {

    @Test
    void isNotFound() {
        //given

        //when
        String message = UserMessage.get(IS_NOT_FOUND, "데이터를");

        //then
        assertEquals("데이터를 찾을 수 없습니다.", message);
    }

    @Test
    void isRequired() {
        //given

        //when
        String message = UserMessage.get(IS_REQUIRED, "이메일 정보는");

        //then
        assertEquals("이메일 정보는 필수 입력값 입니다.", message);
    }
}
