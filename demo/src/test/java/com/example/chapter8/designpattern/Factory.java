package com.example.chapter8.designpattern;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class Factory {

    @Test
    public void test1() {
        System.out.println(ProductFactory.createProduct("loan").showName());
        System.out.println(ProductFactory.createProduct("option").showName());

        try {
            System.out.println(ProductFactory.createProduct("not existed").showName());
            // System.out.println(ProductFactory.createProduct(null).showName());
        } catch (IllegalArgumentException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

class ProductFactory {
    private static Map<String, Supplier<Product>> products = new HashMap<String, Supplier<Product>>() {{
        put("loan", Loan::new);
        put("stock", Stock::new);
        put("bond", Bond::new);
        put("option", () -> () -> "Option");
    }};

    static Product createProduct(String name) {

        return Optional.ofNullable(products.get(name))
                .map(Supplier::get)
                .orElseThrow(() -> new IllegalArgumentException("No such product:" + name));
    }
}

interface Product {
    String showName();
}

class Loan implements Product {

    @Override
    public String showName() {
        return "Loan";
    }
}

class Stock implements Product {

    @Override
    public String showName() {
        return "Stock";
    }
}

class Bond implements Product {

    @Override
    public String showName() {
        return "Bond";
    }
}
