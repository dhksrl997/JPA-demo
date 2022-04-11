package com.example.jpa.jpademo.Entity;
/*
Created on 2022/03/30 1:04 AM In Intelli J IDEA 
by jeon-wangi
*/

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Orders(Member member, Delivery delivery, OrderStatus status, LocalDateTime orderDate) {
        this.member = member;
        this.delivery = delivery;
        this.status = status;
        this.orderDate = orderDate;
    }

    public void addOrderItems(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    //생성 메서드
    public static Orders createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Orders orders = new Orders(member, delivery, OrderStatus.ORDER, LocalDateTime.now());
        for (OrderItem orderItem : orderItems) {
            orders.addOrderItems(orderItem);
        }
        return orders;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    //주문 취소
    public void cancle() {
        if (this.status.equals(DeliveryStatus.COMPLETE)) {
            throw new IllegalArgumentException("이미 배송된 상품입니다.");
        }
        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }

    public int getTotalPrice() {
        return orderItems.stream().mapToInt(OrderItem::getTotalPrice).sum();
    }
}
