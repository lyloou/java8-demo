package com.example.chapter8.designpattern;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;

public class Template {
    @Test
    public void test1() {
        new OnlineBanking().processCustomer(1, customer -> {
            System.out.println(customer.id);
            System.out.println(customer.name);
            System.out.println(customer.age);
        });
    }
}

class OnlineBanking {
    public void processCustomer(int customerId, Consumer<Customer> consumer) {
        // get customer by customerId

        // mock data
        Customer customer = Optional
                .ofNullable(getCustomer(customerId))
                .orElse(new Customer());
        consumer.accept(customer);
    }

    private Customer getCustomer(int customerId) {

        // query with id
        return null;
    }
}

class Customer {
    int id;
    String name;
    String age;
}

