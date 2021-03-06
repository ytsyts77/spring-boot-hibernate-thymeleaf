package com.home.emp.entity;

import com.home.global.common.entity.AuditableEntity;
import com.home.global.common.message.UserMessage;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;

import static com.home.global.common.message.UserMessage.IS_REQUIRED;

@Entity
@Table(name = "emp")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Emp extends AuditableEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", nullable = false)
    private Dept dept;

    @Builder
    public Emp(String firstName, String lastName, String email, Dept dept) {
        Assert.hasText(email, UserMessage.get(IS_REQUIRED, "이메일 정보는"));
        Assert.notNull(dept, UserMessage.get(IS_REQUIRED, "부서 정보는"));

        this.firstName = firstName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dept = dept;
        this.dept.getEmpList().add(this);
    }

    public void updateDept(Dept dept) {
        Assert.notNull(dept, UserMessage.get(IS_REQUIRED, "부서 정보는"));

        if (this.dept == dept)
            return;

        if (this.dept != null) {
            this.dept.getEmpList().remove(this);
        }

        this.dept = dept;
        this.dept.getEmpList().add(this);
    }
}
