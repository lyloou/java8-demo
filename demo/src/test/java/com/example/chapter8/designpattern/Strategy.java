package com.example.chapter8.designpattern;

import org.junit.Test;

public class Strategy {

    @Test
    public void test1() {
        Validator isWord = new Validator((s) -> s.matches("\\w+"));
        Validator isNum = new Validator((s) -> s.matches("\\d+"));
        assert isWord.validate("who");
        assert isNum.validate("123");
    }

}

interface ValidationStrategy {
    boolean execute(String s);
}

class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }
}