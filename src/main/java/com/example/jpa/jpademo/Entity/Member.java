package com.example.jpa.jpademo.Entity;
/*
Created on 2022/03/29 8:56 PM In Intelli J IDEA 
by jeon-wangi
*/

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private int age;

    @Embedded
    private Address address;

    @Column(name = "register_date", nullable = false, updatable = false)
    private LocalDate registerDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<Orders> orders = new ArrayList<>();

    public Member(String name, int age, LocalDate registerDate) {
        this.name = name;
        this.age = age;
        this.registerDate = registerDate;
    }

    public Member(String name, int age, LocalDate registerDate, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.registerDate = registerDate;
    }
}
