package com.home.emp.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        //given
        Emp.EmpBuilder empBuilder = Emp.builder()
                .firstName(firstName)
                .lastName(lastName);

        //expect
        Exception e = assertThrows(IllegalArgumentException.class, empBuilder::build);

        assertEquals("이메일 (은/는) 필수 입력값 입니다.", e.getMessage());
    }

    @Test
    @DisplayName("email 빈값으로 객체 생성")
    void test02() {
        //given
        Emp.EmpBuilder empBuilder = Emp.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email("");

        //expect
        Exception e = assertThrows(IllegalArgumentException.class, empBuilder::build);

        assertEquals("이메일 (은/는) 필수 입력값 입니다.", e.getMessage());
    }

    @Test
    @DisplayName("email null값으로 객체 생성")
    void test01() {
        //given
        Emp.EmpBuilder empBuilder = Emp.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(null);

        //expect
        Exception e = assertThrows(IllegalArgumentException.class, empBuilder::build);

        assertEquals("이메일 (은/는) 필수 입력값 입니다.", e.getMessage());
    }
}
