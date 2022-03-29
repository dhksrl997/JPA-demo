//package com.example.jpa.jpademo.Demo.Conn.Entity;
//
//
//import com.example.jpa.jpademo.Demo.Conn.Enum.RoleType;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.apache.tomcat.jni.Address;
//
//import javax.persistence.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//@Entity
//@Table(name = "member")
//@NoArgsConstructor
//@Getter
//public class Member extends BaseEntity {
//
//    @Column(name = "name")
//    private String name;
//
//    private Integer age;
//
//    @Column(name = "dept", nullable = false)
//    private String dept;
//
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "team_id")
//    private Team team;
//
//    @Embedded
//    private Address address;
//
//    public Member(String name, Integer age, String dept, Address address, RoleType roleType, Team team) {
//        this.name = name;
//        this.age = age;
//        this.dept = dept;
//        this.roleType = roleType;
//        this.team = team;
//        this.address = address;
//        this.team.getMembers().add(this);
//    }
//
//    @Override
//    public String toString() {
//        Map<String, String> map = new HashMap<>();
//        map.put("name", name);
//        map.put("age", String.valueOf(age));
//        map.put("dept", dept);
//        map.put("roleType", String.valueOf(roleType));
//        map.put("address", address.toString());
//        return map.toString();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (! (o instanceof Member)) return false;
//        Member member = (Member) o;
//        return Objects.equals(getName(), member.getName()) && Objects.equals(getAge(), member.getAge()) && Objects.equals(getDept(), member.getDept()) && getRoleType() == member.getRoleType() && Objects.equals(getTeam(), member.getTeam()) && Objects.equals(getAddress(), member.getAddress());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getName(), getAge(), getDept(), getRoleType(), getTeam(), getAddress());
//    }
//}
