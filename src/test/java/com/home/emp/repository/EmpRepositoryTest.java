package com.home.emp.repository;

import com.home.emp.entity.Dept;
import com.home.emp.entity.Emp;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void deleteAll(){
        empRepository.deleteAll();
        deptRepository.deleteAll();
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

        empRepository.save(emp);

        assertEquals(1, empRepository.findAll().size());
        assertEquals(1, deptRepository.findAll().size());

        //when
        deptRepository.save(dept2);
        emp.updateDept(dept2);

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

        empRepository.save(emp);

        assertEquals(1, empRepository.findAll().size());
        assertEquals(1, deptRepository.findAll().size());

        //when
        emp.updateDept(dept);

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
