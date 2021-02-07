package com.home.emp.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString(exclude = "empList")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeptDto {
    private Long id;
    private String name;
    private List<EmpDto> empList;

    @Builder
    public DeptDto(String name) {
        this.name = name;
    }
}
