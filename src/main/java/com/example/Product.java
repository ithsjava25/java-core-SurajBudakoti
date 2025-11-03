package com.example;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private UUID id;
    String name;
    Category category;
    BigDecimal price;

    public Product(UUID id,String name,Category category,BigDecimal price){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public UUID uuid(){
        return id;
    }
    public String name(){
        return name;
    }
    public Category category(){
        return category;
    }
    public BigDecimal price(){
        return price;
    }

    public void price(BigDecimal price){
        this.price = price;
    }
}
