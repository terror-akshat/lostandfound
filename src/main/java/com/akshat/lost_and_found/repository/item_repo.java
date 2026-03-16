package com.akshat.lost_and_found.repository;

import com.akshat.lost_and_found.entity.lost_and_found;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;


public interface item_repo extends MongoRepository<lost_and_found, String> {
    List<lost_and_found> findByItemNameContaining(String name);

    List<lost_and_found> findByStatus(String status);
}