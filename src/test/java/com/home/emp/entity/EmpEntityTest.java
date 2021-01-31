package com.home.emp.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmpEntityTest {
    String firstName = "길동";
    String lastName = "홍";
    String email = "test@email.com";

    @Test
    @DisplayName("모든값 세팅하고 객체 생성")
    void test03() {
        //when
        EmpEntity empEntity = EmpEntity.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();

        //then
        assertEquals(firstName, empEntity.getFirstName());
        assertEquals(lastName, empEntity.getLastName());
        assertEquals(email, empEntity.getEmail());
    }

    @Test
    @DisplayName("email 세팅안하고 객체 생성")
    void test022() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            EmpEntity.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .build();
        });
    }

    @Test
    @DisplayName("email 빈값으로 객체 생성")
    void test02() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            EmpEntity.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email("")
                    .build();
        });
    }

    @Test
    @DisplayName("email null값으로 객체 생성")
    void test01() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            EmpEntity.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(null)
                    .build();
        });
    }
}
