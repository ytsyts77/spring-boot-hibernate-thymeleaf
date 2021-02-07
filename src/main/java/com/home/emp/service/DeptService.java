package com.home.emp.service;

import com.home.emp.entity.Dept;
import com.home.emp.repository.DeptRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class DeptService {
    private final DeptRepository deptRepository;

    @Transactional
    public Dept addDept(Dept dept) {
        return deptRepository.save(dept);
    }
}
