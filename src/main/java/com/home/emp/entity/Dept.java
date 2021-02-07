package com.home.emp.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dept")
@Getter
@ToString(exclude = "empList")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "dept")
    private final List<Emp> empList = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "modified_at", updatable = false)
    private LocalDateTime modifiedAt;

    @Builder
    public Dept(Long id, String name) {
        this.id = id;
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }
}
