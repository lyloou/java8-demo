package com.example.concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);

        Thread printThread = printThread(in);
        printThread.start();


        try {
            int received;
            while ((received = System.in.read()) != -1) {
                out.write(received);
            }
        } finally {
            out.close();
        }
    }

    private static Thread printThread(PipedReader in) {
        return new Thread(() -> {
            int received;
            try {
                while ((received = in.read()) != -1) {
                    System.out.print((char) received);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, "in");
    }
}
