package com.example.jpa.jpademo.Entity.Item;
/*
Created on 2022/03/30 1:22 AM In Intelli J IDEA 
by jeon-wangi
*/

import com.example.jpa.jpademo.Entity.Category;
import com.example.jpa.jpademo.Exception.StockNotEnouthException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // 재고 증가
    public void addStock(int count) {
        this.stockQuantity += count;
    }

    public void removeStock(int count) {
        if (this.stockQuantity - count < 0) {
            throw new StockNotEnouthException("재고 수량이 부족합니다");
        }
        this.stockQuantity -= count;
    }
}
