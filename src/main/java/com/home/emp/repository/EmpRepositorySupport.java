package com.home.emp.repository;

import com.home.emp.entity.Emp;
import com.home.emp.entity.QDept;
import com.home.emp.entity.QEmp;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class EmpRepositorySupport {
    private final JPAQueryFactory query;

    public List<Emp> findByEmail(String email) {
        QEmp e = QEmp.emp;
        QDept d = QDept.dept;

        return query.selectFrom(e)
                .innerJoin(e.dept, d)
                .where(e.email.contains(email))
                .fetch();
    }
}
