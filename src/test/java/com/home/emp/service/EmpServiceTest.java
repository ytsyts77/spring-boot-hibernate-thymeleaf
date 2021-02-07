package com.home.emp.service;

import com.home.emp.dto.DeptDto;
import com.home.emp.dto.EmpDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class EmpServiceTest {
    @Autowired
    EmpService empService;

    @Test
    @DisplayName("사원 등록")
    void add() {
        //given
        DeptDto dept = DeptDto.builder()
                .name("테스트 부서")
                .build();

        EmpDto emp = EmpDto.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .dept(dept)
                .build();

        //when
        empService.addNewEmp(emp);

        //then
        assertEquals(1, empService.getAll().size());
        assertEquals("길동", empService.getAll().get(0).getFirstName());
    }

    @Test
    void get() {
    }
}
