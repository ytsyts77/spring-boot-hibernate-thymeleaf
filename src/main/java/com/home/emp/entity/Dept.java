package com.home.emp.entity;

import com.home.global.entity.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dept")
@Getter
@Setter
@ToString(exclude = "empList")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dept extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "dept")
    private final List<Emp> empList = new ArrayList<>();

    @Builder
    public Dept(String name) {
        this.name = name;
    }
}
