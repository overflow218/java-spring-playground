package com.overflow218.my_first_spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 이제 jpa 를 사용하려면 기존 있던 member클래스에 대해서
 * 이게 디비에 있는 테이블이랑 연결된다는걸 알려줘야함.
 * 그 역할을 하는게 entity라고 생각하면 좋음
 */
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
