package com.home.emp.dto;

import com.home.emp.entity.Emp;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString(exclude = "empList")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeptDto {
    private Long id;
    private String name;
    private List<Emp> empList;

    @Builder
    public DeptDto(String name) {
        this.name = name;
    }
}
