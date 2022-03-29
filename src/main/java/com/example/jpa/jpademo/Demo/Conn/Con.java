//package com.example.jpa.jpademo.Demo.Conn;
///*
//Created on 2022/03/27 4:26 PM In Intelli J IDEA
//by jeon-wangi
//*/
//
//import com.example.jpa.jpademo.Demo.Conn.Entity.Member;
//import com.example.jpa.jpademo.Demo.Conn.Entity.Team;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//public class Con {
//    public void clearEntityManager(EntityManager em) {
//        em.flush();
//        em.clear();
//    }
//
//    public void persistTeam(EntityManager em, List<Team> team) {
//        for (Team t : team) {
//            em.persist(t);
//        }
//    }
//
//    public void persistMembers(EntityManager em, List<Member> members) {
//        for (Member t : members) {
//            em.persist(t);
//        }
//    }
//}
