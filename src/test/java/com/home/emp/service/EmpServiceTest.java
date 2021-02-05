package com.home.emp.service;

import com.home.emp.dto.EmpDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmpServiceTest {
    @Autowired
    EmpService empService;

    @Test
    @DisplayName("사원 등록")
    void add() {
        //given
        EmpDto emp = EmpDto.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .build();

        //when
        empService.add(emp);

        //then
        System.out.println(empService.get(1L));
    }

    @Test
    void get() {
    }
}
