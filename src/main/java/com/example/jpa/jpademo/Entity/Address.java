package com.example.jpa.jpademo.Entity;
/*
Created on 2022/03/30 12:38 AM In Intelli J IDEA 
by jeon-wangi
*/

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

    private String city;
    private String street;
    private String code;

}
