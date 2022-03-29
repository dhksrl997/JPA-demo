//package com.example.jpa.jpademo.Demo.Conn;
//
//import com.example.jpa.jpademo.Demo.Conn.Entity.Address;
//import com.example.jpa.jpademo.Demo.Conn.Entity.Member;
//import com.example.jpa.jpademo.Demo.Conn.Entity.Team;
//import com.example.jpa.jpademo.Demo.Conn.Enum.RoleType;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Demo {
//    public static void main(String[] args) {
//        Con con = new Con();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager(); //EntityManagerFactory를 통해 할당
//        EntityTransaction ex = em.getTransaction();
//        ex.begin(); //트랜잭션 시작
//
//        try {
//            Team team1 = new Team("TeamA", "wesley");
//            Team team2 = new Team("TeamB", "adop");
//
//            em.persist(team1);
//            em.persist(team2);
//            //            con.persistTeam(em, new ArrayList<>(Arrays.asList(team1, team2)));
//
//            List<Member> members = new ArrayList<>(Arrays.asList(new Member("student2", 30, "ops", new Address("서울특별시", "동작구", "국사봉길"), RoleType.STUDENT, team2), new Member("student1", 25, "dev", new Address("서울특별시", "광진구 중곡 3동", "04906"), RoleType.STUDENT, team1), new Member("student3", 32, "dev", new Address("서울특별시", "동작구", "국사봉길"), RoleType.STUDENT, team1), new Member("student4", 11, "dev", new Address("서울특별시", "동작구", "국사봉길"), RoleType.STUDENT, team1), new Member("student5", 10, "ops", new Address("서울특별시", "동작구", "국사봉길"), RoleType.STUDENT, team2), new Member("student6", 23, "ops", new Address("서울특별시", "동작구", "국사봉길"), RoleType.STUDENT, team2)));
//
//            con.persistMembers(em, members);
//
//            con.clearEntityManager(em);
//
//            String query = "select distinct m From Member m join fetch m.team";
//
//            List<Member> result = em.createQuery(query, Member.class).getResultList();
//
//            for (Member m : result) {
//                System.out.println("! = " + m);
//            }
//
//            ex.commit();  //커밋
//            em.close(); //객체 반환
//            emf.close(); //객체 반환
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.close();
//            emf.close();
//        }
//        em.close();
//        emf.close();
//    }
//}