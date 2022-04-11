package com.example.jpa.jpademo.Order.Service;

import com.example.jpa.jpademo.Entity.Address;
import com.example.jpa.jpademo.Entity.Item.Book;
import com.example.jpa.jpademo.Entity.Member;
import com.example.jpa.jpademo.Entity.OrderStatus;
import com.example.jpa.jpademo.Entity.Orders;
import com.example.jpa.jpademo.Order.Repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
Created on 2022/04/11 10:52 PM In Intelli J IDEA 
by jeon-wangi
*/

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    @DisplayName("상품 주문")
    void orderItem() {
        Member member = getMember("member1", 20, new Address("Seoul", "GangNam", "1234"));
        Book book = getBook("전완기", "Test Code", 12000, 10);

        Long orderId = orderService.order(member.getId(), book.getId(), 5);

        Orders getOrder = orderRepository.findOne(orderId);
        assertEquals(String.valueOf(OrderStatus.ORDER), String.valueOf(getOrder.getStatus()), "상품 주문시 상태는 ORDER 인가?");
        assertEquals(1, getOrder.getOrderItems().size(), "주문한 상품 종류 수가 정확한가?");
        assertEquals(12000 * 5, getOrder.getTotalPrice(), "주문 가격은 가격 x 수량인가?");
    }


    @Test
    @DisplayName("재고가 초과된 주문")
    void overQuantityOrder() {
        Member member = getMember("member1", 20, new Address("Seoul", "GangNam", "1234"));
        Book book = getBook("전완기", "Test Code", 12000, 10);

        int orderCount = 20;

        assertThrows(Exception.class, () -> {
            orderService.order(member.getId(), book.getId(), orderCount);
        });
    }

    @Test
    @DisplayName("주문 취소")
    void cancelItem() {
        Member member = getMember("member1", 20, new Address("Seoul", "GangNam", "1234"));
        Book book = getBook("전완기", "Test Code", 12000, 10);

        Long orderId = orderService.order(member.getId(), book.getId(), 3);

        Orders order = orderRepository.findOne(orderId);

        orderService.cancelOrder(order.getId());

        Orders canceledOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.CANCEL, order.getStatus(), "주문이 취소되었으니 상태가 Cancel이어야 한다.");
        assertEquals(10, book.getStockQuantity(), "주문이 취소되었으니 재고가 복구가 되어야 한다.");
    }

    private Book getBook(String author, String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }

    private Member getMember(String name, int age, Address address) {
        Member member = new Member(name, age, LocalDate.now());
        member.setAddress(address);
        em.persist(member);
        return member;
    }
}