//package com.example.jpa.jpademo.Demo.Conn.Entity;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.DynamicInsert;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@NoArgsConstructor
//@Table(name = "team")
//@DynamicInsert
//@Getter
//public class Team extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "owner", nullable = false)
//    private String owner;
//
//    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
//    private List<Member> members = new ArrayList<>();
//
//    public Team(String name, String owner) {
//        this.name = name;
//        this.owner = owner;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (! (o instanceof Team)) return false;
//        Team team = (Team) o;
//        return Objects.equals(getId(), team.getId()) && Objects.equals(getName(), team.getName()) && Objects.equals(getOwner(), team.getOwner()) && Objects.equals(getMembers(), team.getMembers());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getName(), getOwner(), getMembers());
//    }
//
//    @Override
//    public String toString() {
//        return "Team{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", owner='" + owner + '\'' +
//                '}';
//    }
//}
