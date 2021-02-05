package com.home.emp.repository;

import com.home.emp.entity.Dept;
import com.home.emp.entity.Emp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class EmpRepositoryTest {
    @Autowired
    EmpRepository empRepository;
    @Autowired
    DeptRepository deptRepository;

    @AfterEach
    void printAll(){
        List<Emp> empList = empRepository.findAll();
        List<Dept> deptList = deptRepository.findAll();

        System.out.println("------------ emp data ------------");
        empList.forEach(System.out::println);
        System.out.println("------------ dept data ------------");
        deptList.forEach(System.out::println);
        System.out.println("----------------------------------");
    }

    @Test
    void test03(){
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
        emp.updateDept(dept);

        //then
        List<Emp> empList = empRepository.findAll();
        assertEquals(1, empList.size());
    }

    @Test
    void test02(){
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

        //when
        deptRepository.save(dept);
        empRepository.save(emp);

        //then
        List<Emp> empList = empRepository.findAll();
        assertEquals(1, empList.size());
    }

    @Test
    void test01(){
        //given
        Emp emp = Emp.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .build();

        //when
        empRepository.save(emp);

        //then
        List<Emp> empList = empRepository.findAll();
        assertEquals(1, empList.size());
    }
}
