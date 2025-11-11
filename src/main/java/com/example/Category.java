package com.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Category {
    private static final Map<String, Category> CACHE = new ConcurrentHashMap<>();
    private final String name;

    private Category(String name){
        this.name = name;
    }

    public static Category of(String name){
        if (name == null){
            throw new IllegalArgumentException("Category name can't be null");
        }

        String trimmed = name.trim();
        if (trimmed.isEmpty()){
            throw new IllegalArgumentException("Category name can't be blank");
        }

        String firstLetterCapital = trimmed.substring(0, 1).toUpperCase() + trimmed.substring(1).toLowerCase();

        return CACHE.computeIfAbsent(firstLetterCapital, Category::new);
    }
    public String getName(){
        return name;
    }
}
