package com.example.chapter9.interfaces;

import org.junit.Test;

public class Main {
    @Test
    public void main() {
        HelloHi helloHi = new HelloHi();
        helloHi.hello();
        helloHi.heihei();
        helloHi.hi();

        NiHao impl = new NiHaoImpl();
        impl.hi();
        impl.nihao();
        impl.hello();
    }
}
