package com.spring.qudorat.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "phone" , nullable = false)
    private String phone;

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "address" , nullable = false)
    private String address;


}
