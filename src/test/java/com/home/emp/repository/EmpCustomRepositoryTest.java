package com.home.emp.repository;

import com.home.emp.entity.Dept;
import com.home.emp.entity.Emp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmpCustomRepositoryTest {
    @Autowired
    EmpRepository empRepository;
    @Autowired
    DeptRepository deptRepository;

    @BeforeEach
    void clean(){
        empRepository.deleteAll();
        deptRepository.deleteAll();
    }

    @Test
    void test01() {
        //given
        Dept dept = Dept.builder()
                .name("테스트 부서")
                .build();

        Emp emp = Emp.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .dept(dept)
                .build();

        empRepository.save(emp);
        
        //when
        List<Emp> resultList = empRepository.findContainsEmail("test");

        //then
        assertEquals(1, resultList.size());
        assertEquals("길동", resultList.get(0).getFirstName());
    }

}
