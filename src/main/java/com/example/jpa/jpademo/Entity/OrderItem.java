package com.example.jpa.jpademo.Entity;
/*
Created on 2022/03/30 1:20 AM In Intelli J IDEA 
by jeon-wangi
*/

import com.example.jpa.jpademo.Entity.Item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    public OrderItem(Item item, int orderPrice, int count) {
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public void cancel() {
        this.item.addStock(count);
    }

    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }

    //생성 메서드
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        item.removeStock(count);
        return new OrderItem(item, orderPrice, count);
    }
}
