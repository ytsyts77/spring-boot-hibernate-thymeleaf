package com.home.emp.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "EMP")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class EmpEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", nullable = false, updatable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false, updatable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Builder
    public EmpEntity(String firstName, String lastName, String email) {
        Assert.hasText(email, "이메일은 반드시 입력되야 합니다.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
