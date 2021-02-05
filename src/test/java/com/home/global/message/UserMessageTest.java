package com.home.global.message;

import org.junit.jupiter.api.Test;

import static com.home.global.message.UserMessage.IS_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.*;

class UserMessageTest {

    @Test
    void isNotFound() {
        //given

        //when
        String message = UserMessage.get(IS_NOT_FOUND, "데이터");

        //then
        assertEquals("데이터 (을/를) 찾을 수 없습니다.", message);
    }

    @Test
    void isRequired() {
    }
}
