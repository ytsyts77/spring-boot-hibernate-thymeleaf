package com.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    ApplicationRunner makeSomeTestData(DeptRepository deptRepository, EmpRepository empRepository) {
//        return args -> {
//            Dept dept = Dept.builder()
//                    .name("테스트 부서")
//                    .build();
//
//            Emp emp = Emp.builder()
//                    .firstName("길동")
//                    .lastName("홍")
//                    .email("test@email.com")
//                    .dept(dept)
//                    .build();
//
//            deptRepository.save(dept);
//            empRepository.save(emp);
//        };
//    }
}
