package com.home.emp.service;

import com.home.emp.dto.EmpDto;
import com.home.emp.mapper.EmpMapper;
import com.home.emp.repository.EmpRepository;
import com.home.global.error.exception.BusinessException;
import com.home.global.message.UserMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.home.global.message.UserMessage.IS_NOT_FOUND;


@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class EmpService {
    private final EmpRepository empRepository;
    private final EmpMapper empMapper;

    @Transactional
    public void add(EmpDto empDto) {
        empRepository.save(empMapper.toEmp(empDto));
    }

    @Transactional(readOnly = true)
    public EmpDto get(Long id) {
        return empMapper.toEmpDto(empRepository.findById(id)
                .orElseThrow(() -> new BusinessException(UserMessage.get(IS_NOT_FOUND, "데이터"))));
    }

    @Transactional(readOnly = true)
    public List<EmpDto> getAll() {
        return empMapper.toEmpDto(empRepository.findAll());
    }
}
