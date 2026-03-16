package com.akshat.lost_and_found.service;

import com.akshat.lost_and_found.entity.lost_and_found;
import com.akshat.lost_and_found.repository.item_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class item_service {

    @Autowired
    private item_repo repo;

    public lost_and_found addItem(lost_and_found item) {
        item.setStatus("FOUND");
        return repo.save(item);
    }

    public List<lost_and_found> getAll() {
        return repo.findAll();
    }

    public lost_and_found getById(String id) {
        return repo.findById(id).orElse(null);
    }

    public lost_and_found claim(String id) {
        lost_and_found item = repo.findById(id).orElseThrow();
        item.setStatus("CLAIMED");
        return repo.save(item);
    }

    public List<lost_and_found> search(String name) {
        return repo.findByItemNameContaining(name);
    }
}