package com.home.demo.service;

import com.home.demo.exception.RecordNotFoundException;
import com.home.demo.model.EmployeeEntity;
import com.home.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> result = (List<EmployeeEntity>) repository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
        Optional<EmployeeEntity> employee = repository.findById(id);
        return employee
                .orElseThrow(() -> new RecordNotFoundException("No employee record exist for given id"));
    }

    public void createOrUpdateEmployee(EmployeeEntity entity) {
        repository.save(entity);
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException {
        Optional<EmployeeEntity> employee = repository.findById(id);

        if (employee.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}
