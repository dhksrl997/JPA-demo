package com.example.jpa.jpademo.Entity.Item;
/*
Created on 2022/03/30 1:30 AM In Intelli J IDEA 
by jeon-wangi
*/

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("book")
public class Book extends Item {
    private String author;
    private String isbn;
}
