package com.example.jpa.jpademo.Entity;
/*
Created on 2022/03/30 1:20 AM In Intelli J IDEA 
by jeon-wangi
*/

import com.example.jpa.jpademo.Entity.Item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order;

    private int orderPrice;
    private int count;

}
