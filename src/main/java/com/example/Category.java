package com.example;

public class Category {
    private String name;

    private Category(String name){
        this.name = name;
    }

    public static Category of(String name){
        if (name.isEmpty() || name == null || name.equals(" ")){
            throw new IllegalArgumentException("String can't be null, empty or single whitespace");
        }

        return new Category(name);
    }
    public String getName(){
        return name;
    }
}
