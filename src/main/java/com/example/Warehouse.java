package com.example;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {
    private static final Map<String, Warehouse> instances = new HashMap<>();
    List<Product> productList = new ArrayList<>();

    private Warehouse(){};

    public List<Product> getProducts(){
        return productList.stream().toList();
    }

    public List<Shippable> shippableProducts(){
        return productList.stream()
                .filter(product -> product instanceof Shippable)
                .map(product -> (Shippable) product)
                .collect(Collectors.toList());
    }

    public static Warehouse getInstance(String name){
        return instances.computeIfAbsent(name, k -> new Warehouse());
    }

    public static Warehouse getInstance(){
        return new Warehouse();
    }


    public boolean isEmpty(){
        return productList.isEmpty();
    }

    public void addProduct(Product productName){
        if (productName == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        for (Product product: productList){
            if (product.uuid() == (productName.uuid())){
                throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");
            }
        }

        instances.clear();
        productList.add(productName);
    }

    public void updateProductPrice(UUID uuid, BigDecimal newPrice){
        Product product = productList.stream()
                .filter(p -> p.uuid().equals(uuid))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product not found with id:"));

        // Update price
        product.price(newPrice); // assuming Product has a setter price(BigDecimal)

    }

    public Optional<Product> getProductById(UUID id){
        return productList.stream().filter(product -> product.uuid().equals(id)).findFirst();
    }

    public Map<Category, List<Product>> getProductsGroupedByCategories(){
        return productList.stream()
                .collect(Collectors.groupingBy(Product::category, LinkedHashMap::new, Collectors.toList()));
    }

    public void remove(UUID uuid){
        productList.removeIf(product -> product.uuid().equals(uuid));
    }

    public List<Perishable> expiredProducts(){
        return productList.stream()
                .filter(product -> product instanceof Perishable).map(product -> (Perishable) product)
                .filter(Perishable::isExpired)
                .collect(Collectors.toList());
    }

    public void clearProducts() {
    }
}
