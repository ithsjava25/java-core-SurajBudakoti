package com.example;
import java.math.BigDecimal;
import java.util.UUID;

public class ElectronicsProduct extends Product implements Shippable{
    private final int warrantyMonths;
    private final BigDecimal weight;

    public ElectronicsProduct(UUID id, String name, Category category, BigDecimal price, int warrantyMonths, BigDecimal weight){
        if (warrantyMonths < 0){
            throw new IllegalArgumentException("Warranty months cannot be negative.");
        }
        super(id,  name,  category,  price);
        this.warrantyMonths = warrantyMonths;
        this.weight = weight;

    }

    @Override
    public BigDecimal calculateShippingCost() {
        BigDecimal baseShipingPrice = new BigDecimal("79");
        if (weight.compareTo(new BigDecimal("5")) > 0){
            return baseShipingPrice.add(new BigDecimal("49"));
        }
        return baseShipingPrice;
    }

    @Override
    public double weight() {
        return weight.doubleValue();
    }

    public String productDetails(){
        return "Electronics: " + super.name() + ", Warranty: " + warrantyMonths + " months";
    }
}
