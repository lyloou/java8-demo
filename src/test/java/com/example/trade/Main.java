package com.example.trade;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {
    private Trader raoul = new Trader("Raoul", "Cambridge");
    private Trader mario = new Trader("Mario", "Milan");
    private Trader alan = new Trader("Alan", "Cambridge");
    private Trader brian = new Trader("Brian", "Cambridge");

    private List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(brian, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );


    @Test
    public void p1() {
        System.out.println(transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(toList())
        );
    }

    @Test
    public void p2() {
        System.out.println(transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList()));
    }

    @Test
    public void p3() {
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList()));
    }

    @Test
    public void p4() {
        System.out.println(transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
//                .collect(joining()));
                .reduce("", (a, b) -> a + b));
    }

    @Test
    public void p5() {
        System.out.println(transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan")));
    }

    @Test
    public void p6() {
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .forEach(System.out::println);
    }

    @Test
    public void p7() {
        System.out.println(transactions.stream()
                .mapToInt(Transaction::getValue)
                .reduce(0, Integer::max));
    }

    @Test
    public void p8() {
        System.out.println(transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue)));
    }

}
