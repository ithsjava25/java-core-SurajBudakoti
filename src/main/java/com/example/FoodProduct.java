package com.example;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class FoodProduct extends Product implements Perishable, Shippable{
    private LocalDate expirationDate;
    private BigDecimal weight;

    public FoodProduct(UUID id, String name, Category category, BigDecimal price, LocalDate expirationDate, BigDecimal weight) {
        if(price.compareTo(BigDecimal.ZERO) < 0 || weight.compareTo(BigDecimal.ZERO)<0) {
            throw new IllegalArgumentException("Price and/or weight cannot be negative.");
        }

        super(id, name, category, price);

        this.expirationDate= expirationDate;
        this.weight= weight;
    }
    public LocalDate expirationDate (){
        return expirationDate;
    }


    public BigDecimal calculateShippingCost(){
        return weight.multiply(BigDecimal.valueOf(50));
    }

    @Override
    public double weight() {
        return weight.doubleValue();
    }
}
