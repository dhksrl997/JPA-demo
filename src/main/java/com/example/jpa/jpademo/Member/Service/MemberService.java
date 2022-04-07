package com.example.jpa.jpademo.Member.Service;
/*
Created on 2022/03/30 10:20 PM In Intelli J IDEA 
by jeon-wangi
*/

import com.example.jpa.jpademo.Entity.Member;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class MemberService {
    @PersistenceContext
    EntityManager em;

    public void selectDuplicateMember(Member member) {
        Member existMember = em.createQuery("SELECT m from Member m where m.name=:name", Member.class)
                .setParameter("name", member.getName())
                .getSingleResult();
        if (existMember != null) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
    }
}