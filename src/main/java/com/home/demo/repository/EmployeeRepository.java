package com.home.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home.demo.model.EmployeeEntity;

@Repository
public interface EmployeeRepository
        extends CrudRepository<EmployeeEntity, Long> {
}
