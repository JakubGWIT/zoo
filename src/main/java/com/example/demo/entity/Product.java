package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private Long id;
    private String name;
//    private Double price;
//    private int count;

}
