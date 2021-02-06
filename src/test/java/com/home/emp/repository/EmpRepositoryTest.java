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
    void printAll() {
        List<Emp> empList = empRepository.findAll();
        List<Dept> deptList = deptRepository.findAll();

        System.out.println("------------ emp data ------------");
        empList.forEach(System.out::println);
        System.out.println("------------ dept data ------------");
        deptList.forEach(System.out::println);
        System.out.println("----------------------------------");
    }

    @Test
    void test06() {
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
        assertEquals(1, empRepository.findAll().size());
        assertEquals(1, deptRepository.findAll().size());

        assertEquals(dept, deptRepository.findById(dept.getId()).get());
        assertEquals(1, dept.getEmpList().size());
    }

    @Test
    void test05() {
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
        assertEquals(1, empRepository.findAll().size());
        assertEquals(1, deptRepository.findAll().size());
        assertEquals(1, dept.getEmpList().size());
    }

    @Test
    void test04() {
        //given
        Dept dept1 = Dept.builder()
                .name("테스트 부서1")
                .build();

        Dept dept2 = Dept.builder()
                .name("테스트 부서2")
                .build();

        Emp emp = Emp.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .dept(dept1)
                .build();

        deptRepository.save(dept1);
        deptRepository.save(dept2);
        empRepository.save(emp);

        assertEquals(1, empRepository.findAll().size());
        assertEquals(2, deptRepository.findAll().size());

        //when
        emp.updateDept(dept2);

        //then
        assertEquals(dept2, empRepository.findById(emp.getId()).get().getDept());
    }

    @Test
    void test03() {
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

        assertEquals(1, empRepository.findAll().size());
        assertEquals(1, deptRepository.findAll().size());

        //when
        emp.updateDept(dept);

        //then
        assertEquals(dept, empRepository.findById(emp.getId()).get().getDept());
    }

    @Test
    void test02() {
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
        assertEquals(1, empRepository.findAll().size());
        assertEquals(1, deptRepository.findAll().size());
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

        //when
        deptRepository.save(dept);
        empRepository.save(emp);

        //then
        assertEquals(1, empRepository.findAll().size());
        assertEquals(1, deptRepository.findAll().size());
    }

//    @Test
//    void test00() {
//        //given
//        Dept dept = Dept.builder()
//                .name("테스트 부서")
//                .build();
//
//        Emp emp = Emp.builder()
//                .firstName("길동")
//                .lastName("홍")
//                .email("test@email.com")
//                .dept(dept)
//                .build();
//
//        //expect
//        assertThrows(InvalidDataAccessApiUsageException.class, () -> empRepository.save(emp));
//    }
}
