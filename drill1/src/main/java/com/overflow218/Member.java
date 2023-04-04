package com.overflow218;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
/**
 * 기본적으로 엔터티를 만들면 id로 프라이머리키를 지정해주어야함
 * 이때 pk가 어떻게 증가할것인지를 지정해줄수 있는데 그게 내 자유임
 * 사용가능한 옵션이 한 3가지 있음
 * 0. 수동으로 매번 넣어주는 경우 -> @id면 충분
 * 1. 자동 생성 -> mysql auto increment 같은거
 * 2. 시퀀스로 생성
 * 3. 이거 담당하는 테이블 만들기
 */
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Integer age;

    /**
     * 무조건 EnumType.String으로 넣어줘야함
     * ordinal로 넣으면 0, 1, 2, ... 이렇게 들어가는데
     * 나중에 이넘값이 추가되거나 삭제되면 골때림
     * 무조건 스트링으로 넣어주기
     */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private LocalDate createdDate;

    private LocalDate lastModifiedDate;

    @Lob // 엄청 큰 데이터 타입 blob, clob이런건 lob을 활용해서 사용함!
    private String description;

    @Transient // 이건 이제 맵핑안하고 로컬 객채에만 붙는값임
    private Integer localCache;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
