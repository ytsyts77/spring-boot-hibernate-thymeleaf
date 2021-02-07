package com.home.emp.service;

import com.home.emp.dto.DeptDto;
import com.home.emp.dto.EmpDto;
import com.home.emp.entity.Dept;
import com.home.emp.mapper.DeptMapper;
import com.home.emp.mapper.EmpMapper;
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

    @Autowired
    DeptService deptService;

    @Autowired
    EmpMapper empMapper;

    @Autowired
    DeptMapper deptMapper;

    @Test
    @DisplayName("사원 등록")
    void add() {
        //given
        DeptDto deptDto = DeptDto.builder()
                .name("테스트 부서")
                .build();

        Dept dept = deptService.addDept(deptMapper.toDept(deptDto));

        EmpDto emp = EmpDto.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .dept(deptMapper.toDeptDto(dept))
                .build();

        //when
        empService.addEmp(empMapper.toEmp(emp));

        //then
        assertEquals(1, empService.getAll().size());
        assertEquals("길동", empService.getAll().get(0).getFirstName());
    }

    @Test
    void get() {
    }
}
