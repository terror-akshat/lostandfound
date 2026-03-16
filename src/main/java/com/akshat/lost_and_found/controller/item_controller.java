package com.akshat.lost_and_found.controller;

import com.akshat.lost_and_found.entity.lost_and_found;
import com.akshat.lost_and_found.service.item_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/items")
public class item_controller {

    @Autowired
    private item_service service;

    @PostMapping
    public ResponseEntity<lost_and_found> addItem(@RequestBody lost_and_found item) {
        try {
            service.addItem(item);
            return new ResponseEntity<lost_and_found>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<lost_and_found> getAll() {
        try {
            service.getAll();
            return new ResponseEntity<lost_and_found>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<lost_and_found> getById(@PathVariable String id) {
        try {
            lost_and_found item = service.getById(id);
            if (item == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<lost_and_found>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/search")
    public ResponseEntity<lost_and_found> search(@RequestParam String name) {
        try {
            List<lost_and_found> item = service.search(name);
            if (item.size() == 0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<lost_and_found>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/claim")
    public ResponseEntity<lost_and_found> claim(@PathVariable String id) {
        try {
            service.claim(id);
            return new ResponseEntity<lost_and_found>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}