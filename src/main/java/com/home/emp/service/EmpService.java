package com.home.emp.service;

import com.home.emp.dto.EmpDto;
import com.home.emp.entity.EmpEntity;
import com.home.emp.repository.EmpRepository;
import com.home.global.error.exception.BusinessException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional
public class EmpService {
    private final EmpRepository empRepository;

    @Transactional
    public void add(EmpDto empDto) {
        empRepository.save(empDto.toEntity());
    }

    @Transactional(readOnly = true)
    public EmpDto get(Long id) {
        EmpEntity empEntity = empRepository.findById(id)
                .orElseThrow(() -> new BusinessException("데이터를 찾을 수 없습니다."));

        return EmpDto.fromEntity(empEntity);
    }
}
