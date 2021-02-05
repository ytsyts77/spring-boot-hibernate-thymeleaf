package com.home.emp.entity;

import com.home.global.message.UserMessage;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.home.global.message.UserMessage.IS_REQUIRED;

@Entity
@Table(name = "emp")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Builder
    public Emp(String firstName, String lastName, String email, Dept dept) {
        Assert.hasText(email, UserMessage.get(IS_REQUIRED, "이메일"));

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dept = dept;
        this.createdAt = LocalDateTime.now();
    }

    public void updateDept(Dept dept){
        Assert.notNull(dept, UserMessage.get(IS_REQUIRED, "부서 정보"));

        if (dept == dept)
            return;

        this.dept = dept;
        this.modifiedAt = LocalDateTime.now();
    }
}
