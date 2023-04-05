package com.overflow218.jpaBook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    @GeneratedValue()
    @Column(name="member_id")
    private Long id;

    @Column(length = 20)
    private String name;
    @Column(length = 30)
    private String city;
    @Column(length = 30)
    private String Street;
    @Column(length = 30)
    private String Zipcode;

    /**
     * 영한님왈.
     * 게터야 상관없는데 세터는 무조건 막 만든다고좋은게 아니래
     * 생성자에만 받아서 딱 만들고 수정을 못하게 하는게 더 좋은
     * 상황인 경우가 있을 수 있음!
     */


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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }
}
