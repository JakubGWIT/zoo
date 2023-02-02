package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="product")
public class Product {

    private int id;
    private String name;
    private int price;

    @Id
    @XmlElement(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product ProductBuilder() {
        return new Product(id, name, price);
    }

}
