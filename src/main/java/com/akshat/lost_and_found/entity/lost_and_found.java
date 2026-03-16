package com.akshat.lost_and_found.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Document(collection = "items")
public class lost_and_found {

    private String id;

    private String itemName;
    private String color;
    private String placeFound;
    private String description;

    private LocalDate dateFound;
    private LocalTime timeFound;

    private String status;
}