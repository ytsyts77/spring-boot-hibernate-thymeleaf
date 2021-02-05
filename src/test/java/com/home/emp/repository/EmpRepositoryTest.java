package com.home.emp.repository;

import com.home.emp.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class EmpRepositoryTest {
    @Autowired
    EmpRepository empRepository;

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
        List<Emp> emps = empRepository.findAll();
        assertEquals(1, emps.size());
    }
}
