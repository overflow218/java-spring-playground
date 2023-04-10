package com.overflow218.jpaBook.domain;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id @GeneratedValue()
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    @Column(length = 30)
    private String city;
    @Column(length = 30)
    private String Street;
    @Column(length = 30)
    private String Zipcode;
}
