package com.example.concurrent.observerset;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set1, Integer element) {
                System.out.println(element);
                if (element == 23) {
                    set1.removeObserver(this);
                    System.out.println("--------------------");
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
