package com.home.emp.dto;

import com.home.emp.entity.Emp;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EmpDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Builder
    public EmpDto(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public static EmpDto fromEntity(Emp entity) {
        EmpDto dto = EmpDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .build();
        dto.id = entity.getId();
        return dto;
    }

    public Emp toEntity() {
        return Emp.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();
    }
}
