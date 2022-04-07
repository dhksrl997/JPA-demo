package com.example.jpa.jpademo.Member.Repository;
/*
Created on 2022/03/29 8:54 PM In Intelli J IDEA 
by jeon-wangi
*/

import com.example.jpa.jpademo.Entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

    public void flushEntityManager() {
        this.em.flush();
        this.em.clear();
    }
}
