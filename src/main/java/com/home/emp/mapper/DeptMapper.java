package com.home.emp.mapper;

import com.home.emp.dto.DeptDto;
import com.home.emp.entity.Dept;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeptMapper {
    DeptDto toDeptDto(Dept dept);
    List<DeptDto> toDeptDto(List<Dept> deptList);
    Dept toDept(DeptDto deptDto);
    List<Dept> toDeptList(List<DeptDto> deptDtoList);
}
