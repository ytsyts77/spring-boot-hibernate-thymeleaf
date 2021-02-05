package com.home.emp.service;

import com.home.emp.dto.EmpDto;
import com.home.emp.entity.Emp;
import com.home.emp.repository.EmpRepository;
import com.home.global.error.exception.BusinessException;
import com.home.global.message.UserMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.home.global.message.UserMessage.IS_NOT_FOUND;


@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional
public class EmpService {
    private final EmpRepository empRepository;

    @Transactional
    public void add(EmpDto emp) {
        empRepository.save(emp.toEntity());
    }

    @Transactional(readOnly = true)
    public Emp get(Long id) {
        return empRepository.findById(id)
                .orElseThrow(() -> new BusinessException(UserMessage.get(IS_NOT_FOUND, "데이터")));
    }
}
