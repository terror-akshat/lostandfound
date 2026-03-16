package com.akshat.lost_and_found.controller;

import com.akshat.lost_and_found.entity.lost_and_found;
import com.akshat.lost_and_found.service.item_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class item_controller {

    @Autowired
    private item_service service;

    @PostMapping
    public lost_and_found addItem(@RequestBody lost_and_found item) {
        return service.addItem(item);
    }

    @GetMapping
    public List<lost_and_found> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public lost_and_found getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/search")
    public List<lost_and_found> search(@RequestParam String name) {
        return service.search(name);
    }

    @PutMapping("/{id}/claim")
    public lost_and_found claim(@PathVariable String id) {
        return service.claim(id);
    }
}