package com.halmaks.coins.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "product")
public class Product {

    private int id;
    private String name;
    private String description;
    private int price;

    public Product() {

    }

    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Column(name = "name", nullable = false)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Column(name = "description", nullable = false)
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    @Column(name = "price", nullable = false)
    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name +
                ", description=" + description +
                ", price=" + price +
                "]";
    }
}
