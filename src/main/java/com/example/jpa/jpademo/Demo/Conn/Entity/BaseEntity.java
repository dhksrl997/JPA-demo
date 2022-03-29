//package com.example.jpa.jpademo.Demo.Conn.Entity;
///*
//Created on 2022/03/22 11:51 PM In Intelli J IDEA
//by jeon-wangi
//*/
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@MappedSuperclass
//public abstract class BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "registerDate", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL")
//    private LocalDateTime registerDate;
//
//    @Column(name = "modifiedDate")
//    private LocalDateTime modifiedDate;
//}
