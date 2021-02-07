package com.home.emp.repository;

import com.home.emp.entity.Emp;
import com.home.emp.entity.QDept;
import com.home.emp.entity.QEmp;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmpCustomRepositoryImpl implements EmpCustomRepository {
    private final JPAQueryFactory query;

    @Override
    public List<Emp> findContainsEmail(String email) {
        QEmp e = QEmp.emp;
        QDept d = QDept.dept;

        return query.selectFrom(e)
                .where(e.email.contains(email))
                .fetch();
    }
}
