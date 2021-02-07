package com.home.emp.repository;

import com.home.emp.entity.Dept;
import com.home.emp.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class EmpRepositoryTest {
    @Autowired
    EmpRepository empRepository;
    @Autowired
    DeptRepository deptRepository;

    @Test
    void test07() {
        //given
        Dept dept = Dept.builder()
                .name("테스트 부서")
                .build();

        Emp emp1 = Emp.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test1@email.com")
                .dept(dept)
                .build();

        Emp emp2 = Emp.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test2@email.com")
                .dept(dept)
                .build();

        //when
        deptRepository.save(dept);
        empRepository.save(emp1);
        empRepository.save(emp2);


        //then
        assertEquals(2, empRepository.findAll().size());
        assertEquals(1, deptRepository.findAll().size());

        assertEquals(dept.getId(), deptRepository.findById(dept.getId()).get().getId());
        assertEquals(2, dept.getEmpList().size());
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

        assertEquals(dept.getId(), deptRepository.findById(dept.getId()).get().getId());
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
        empRepository.save(emp);

        assertEquals(1, empRepository.findAll().size());
        assertEquals(1, deptRepository.findAll().size());

        //when
        deptRepository.save(dept2);
        emp.setDept(dept2);

        //then
        assertEquals(dept2.getName(), empRepository.findById(emp.getId()).get().getDept().getName());
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
        emp.setDept(dept);

        //then
        assertEquals(dept.getId(), empRepository.findById(emp.getId()).get().getDept().getId());
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
