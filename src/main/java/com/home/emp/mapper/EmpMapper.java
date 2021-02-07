package com.home.emp.mapper;

import com.home.emp.dto.EmpDto;
import com.home.emp.entity.Emp;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpMapper {
    EmpDto toEmpDto(Emp emp);
    List<EmpDto> toEmpDto(List<Emp> emp);
    Emp toEmp(EmpDto empDto);
    List<Emp> toEmp(List<EmpDto> emp);
}
