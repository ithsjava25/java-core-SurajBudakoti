package com.example;
import java.math.BigDecimal;
import java.util.UUID;

public class ElectronicsProduct extends Product implements Shippable{
    private int warrantyMonths;
    private BigDecimal weight;

    public ElectronicsProduct(UUID id, String name, Category category, BigDecimal price, int warrantyMonths, BigDecimal weight){
        super( id,  name,  category,  price);
        this.warrantyMonths = warrantyMonths;
        this.weight = weight;

    }

    @Override
    public BigDecimal calculateShippingCost() {
        if (weight.compareTo(new BigDecimal("5")) > 0){
            return price.add(new BigDecimal("128"));
        }
        else return price.add(new BigDecimal("79"));
    }

    @Override
    public double weight() {
        return weight.doubleValue();
    }
}
