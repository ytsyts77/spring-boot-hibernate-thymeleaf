package com.home.emp.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmpDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private DeptDto dept;

    @Builder
    public EmpDto(String firstName, String lastName, String email, DeptDto dept) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dept = dept;
    }
}
