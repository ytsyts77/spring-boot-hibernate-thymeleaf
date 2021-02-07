package com.home.emp.service;

import com.home.emp.entity.Emp;
import com.home.emp.repository.EmpRepository;
import com.home.global.error.exception.BusinessException;
import com.home.global.common.message.UserMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.home.global.common.message.UserMessage.IS_NOT_FOUND;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class EmpService {
    private final EmpRepository empRepository;

    @Transactional
    public void addEmp(Emp emp) {
        empRepository.save(emp);
    }

    @Transactional(readOnly = true)
    public Emp get(Long id) {
        return empRepository.findById(id)
                .orElseThrow(() -> new BusinessException(UserMessage.get(IS_NOT_FOUND, "사원 정보를")));
    }

    @Transactional(readOnly = true)
    public List<Emp> getAll() {
        return empRepository.findAll();
    }
}
