package com.example.jpa.jpademo.Order.Service;
/*
Created on 2022/04/07 8:24 PM In Intelli J IDEA 
by jeon-wangi
*/

import com.example.jpa.jpademo.Entity.*;
import com.example.jpa.jpademo.Entity.Item.Item;
import com.example.jpa.jpademo.Item.Repository.ItemRepository;
import com.example.jpa.jpademo.Member.Repository.MemberRepository;
import com.example.jpa.jpademo.Order.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;


    /*
     * 주문
     * */
    public Long order(Long memberID, Long itemID, int count) {
        Member member = memberRepository.find(memberID);
        Item item = itemRepository.findOne(itemID);

        Delivery delivery = new Delivery(member.getAddress(), DeliveryStatus.READY);

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        Orders orders = Orders.createOrder(member, delivery, orderItem);

        orderRepository.save(orders);

        return orders.getId();
    }

    @Transactional
    public void cancelOrder(Long orderID) {
        Orders order = orderRepository.findOne(orderID);
        order.cancle();
    }

    public List<Orders> searchOrders() {
        return null;
    }
}
