package com.home.emp.repository;

import com.home.emp.entity.Emp;

import java.util.List;

public interface EmpCustomRepository {
    public List<Emp> findContainsEmail(String email);
}
