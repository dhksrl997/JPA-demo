package com.example.jpa.jpademo.Item.Service;
/*
Created on 2022/04/07 7:38 PM In Intelli J IDEA 
by jeon-wangi
*/

import com.example.jpa.jpademo.Entity.Item.Item;
import com.example.jpa.jpademo.Item.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository repository;

    @Transactional
    public void save(Item item) {
        repository.save(item);
    }

    public Item findOne(Long id) {
        return repository.findOne(id);
    }

    public List<Item> findItems() {
        return repository.findAll();
    }
}
