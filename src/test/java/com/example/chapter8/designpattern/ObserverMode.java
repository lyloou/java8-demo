package com.example.chapter8.designpattern;

import org.junit.Test;

import java.util.Observable;
import java.util.Optional;

public class ObserverMode {

    @Test
    public void test1() {
        Subject subject = new Subject();

        subject.addObserver((o, arg) -> Optional.ofNullable(arg)
                .map(String::valueOf)
                .filter(s -> s.contains("money"))
                .ifPresent(s -> {
                    // do sth
                    System.out.println("Breaking news in NY!   (" + s + ")");
                }));

        subject.addObserver((o, arg) -> Optional.ofNullable(arg)
                .map(String::valueOf)
                .filter(s -> s.contains("queen"))
                .ifPresent(s -> {
                    // do sth
                    System.out.println("Yet another news in London. (" + s + ")");
                }));

        subject.setTweet(null);
        subject.setTweet("money");
        subject.setTweet("queen");
        subject.setTweet("the queen spend money");
    }

}


class Subject extends Observable {

    public void setTweet(String tweet) {
        setChanged();
        notifyObservers(tweet);
    }
}