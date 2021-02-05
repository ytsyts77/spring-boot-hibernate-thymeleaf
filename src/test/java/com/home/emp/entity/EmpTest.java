package com.home.emp.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmpTest {
    String firstName = "길동";
    String lastName = "홍";
    String email = "test@email.com";

    @Test
    @DisplayName("모든값 세팅하고 객체 생성")
    void test03() {
        //when
        Emp emp = Emp.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();

        //then
        assertEquals(firstName, emp.getFirstName());
        assertEquals(lastName, emp.getLastName());
        assertEquals(email, emp.getEmail());
    }

    @Test
    @DisplayName("email 세팅안하고 객체 생성")
    void test022() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Emp.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .build();
        });
    }

    @Test
    @DisplayName("email 빈값으로 객체 생성")
    void test02() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Emp.builder()
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
            Emp.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(null)
                    .build();
        });
    }
}
