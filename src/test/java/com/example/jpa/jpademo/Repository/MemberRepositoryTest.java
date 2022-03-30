package com.example.jpa.jpademo.Repository;

/*
Created on 2022/03/29 8:59 PM In Intelli J IDEA 
by jeon-wangi
*/

import com.example.jpa.jpademo.Entity.Address;
import com.example.jpa.jpademo.Entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Test
    @DisplayName("회원 가입 테스트")
    @Transactional
    @Rollback(value = false)
    public void saveTest() {
        Long id = repository.save(new Member("Wangi", 28, LocalDate.now(), new Address("서울특별시", "긴고랑로 1길", "04123")));

        repository.flushEntityManager();

        Member member = repository.find(id);
        System.out.println("! member = " + member);
        Assertions.assertThat(member.getId()).isEqualTo(id);
    }
}