package com.home.emp.repository;

import com.home.emp.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long>, EmpCustomRepository {
}
