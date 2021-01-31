package com.home.emp.repository;

import com.home.emp.entity.EmpEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends CrudRepository<EmpEntity, Long> {
}
