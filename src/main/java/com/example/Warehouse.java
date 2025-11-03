package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Warehouse {
    static Warehouse warehouse;
    List<Product> productList = new ArrayList<>();

    public List<Product> getProducts(){
        return productList;
    }

    public List<Shippable> shippableProducts(){
        return productList.stream()
                .map(product -> (Shippable) product).toList();
    }

    public static Warehouse getInstance(String name){
        return warehouse;
    }

    public static Warehouse getInstance(){
        return new Warehouse();
    }


    public boolean isEmpty(){
        return productList.isEmpty();
    }

}
