package com.example.chapter8;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {
    public static String processFile(BufferReaderProcessor processor) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(reader);
        }
    }

    @Test
    public void test1() throws IOException {
        String s = processFile(reader -> reader.readLine());
        String s2 = processFile(reader -> reader.readLine() + reader.readLine());
        System.out.println(s);
        System.out.println(s2);
    }
}

interface BufferReaderProcessor {
    String process(BufferedReader reader) throws IOException;
}


