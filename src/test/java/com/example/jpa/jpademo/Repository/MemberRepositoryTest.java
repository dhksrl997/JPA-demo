package com.example.jpa.jpademo.Repository;

/*
Created on 2022/03/29 8:59 PM In Intelli J IDEA 
by jeon-wangi
*/

import com.example.jpa.jpademo.Entity.Address;
import com.example.jpa.jpademo.Entity.Member;
import com.example.jpa.jpademo.Member.Repository.MemberRepository;
import com.example.jpa.jpademo.Member.Service.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Autowired
    MemberService service;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("회원 가입 테스트")
    @Transactional
    @Rollback(value = false)
    public void saveTest() {
        System.out.println("! = " + LocalDateTime.now());
        Member member1 = new Member("Student1", 28, LocalDate.now(), new Address("서울특별시", "긴고랑로 1길", "04123"));
        Member member2 = new Member("Student2", 30, LocalDate.now(), new Address("서울특별시", "긴고랑로 2길", "02122"));
        Member member3 = new Member("Student3", 31, LocalDate.now(), new Address("서울특별시", "긴고랑로 3길", "05921"));
        Long save = repository.save(member1);
        Long save1 = repository.save(member2);
        Long save2 = repository.save(member3);

        repository.flushEntityManager();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.selectDuplicateMember(new Member());
        });
    }
}