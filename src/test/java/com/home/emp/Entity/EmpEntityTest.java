package com.home.emp.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmpEntityTest {
    @Test
    @DisplayName("email 빈값이 들어갔을 경우, 오류발생")
    void test01() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            EmpEntity empEntity = EmpEntity.builder()
                    .firstName("태식")
                    .lastName("윤")
                    .email("")
                    .build();
        });
    }

    @Test
    @DisplayName("email null 이 들어갔을 경우, 오류발생")
    void test02() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            EmpEntity empEntity = EmpEntity.builder()
                    .firstName("태식")
                    .lastName("윤")
                    .email(null)
                    .build();
        });
    }
}
