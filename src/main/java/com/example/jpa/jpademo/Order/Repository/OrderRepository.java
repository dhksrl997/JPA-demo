package com.example.jpa.jpademo.Order.Repository;
/*
Created on 2022/04/07 8:19 PM In Intelli J IDEA 
by jeon-wangi
*/

import com.example.jpa.jpademo.Entity.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;


    public void save(Orders orders) {
        em.persist(orders);
    }

    public Orders findOne(Long id) {
        return em.find(Orders.class, id);
    }

//    public List<Orders> search(OrderSearch OrderSearch){
//        return
//    }
}
