package com.example.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    @Test
    public void read() throws IOException {
        File file = new File("data.txt");
        FileInputStream fis = new FileInputStream(file);
        FileChannel channel = fis.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();

//        https://stackoverflow.com/questions/29190684/convert-bytebuffer-to-string-in-java
//        byte[] result = new byte[buffer.remaining()];
//        buffer.get(result);
//        String s = new String(result);
//        System.out.println(s);

        String s = new String(buffer.array(), 0, buffer.remaining());
        System.out.println(s);

        fis.close();
        channel.close();
    }

    @Test
    public void write() throws IOException {
        File file = new File("data.txt");
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel channel = fos.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello, nio".getBytes());
        buffer.flip();

        channel.write(buffer);
        channel.close();
        fos.close();
    }
}
