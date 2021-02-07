package com.home.emp.dto;

import com.home.emp.entity.Emp;
import lombok.*;

import java.util.List;

@Getter
@ToString(exclude = "empList")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeptDto {
    private Long id;
    private String name;
    private List<Emp> empList;

    @Builder
    public DeptDto(Long id, String name, List<Emp> empList) {
        this.id = id;
        this.name = name;
        this.empList = empList;
    }
}
