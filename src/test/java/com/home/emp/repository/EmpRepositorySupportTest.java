package com.home.emp.repository;

import com.home.emp.entity.Dept;
import com.home.emp.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmpRepositorySupportTest {
    @Autowired
    EmpRepositorySupport empRepositorySupport;
    @Autowired
    EmpRepository empRepository;
    @Autowired
    DeptRepository deptRepository;

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

        deptRepository.save(dept);
        empRepository.save(emp);

        //when
        List<Emp> resultList = empRepositorySupport.findByEmail("test@email.com");

        //then
        assertEquals(1, resultList.size());
    }

}
