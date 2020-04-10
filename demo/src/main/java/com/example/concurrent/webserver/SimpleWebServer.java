package com.example.concurrent.webserver;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {
    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>(1);
    static String basePath;
    static ServerSocket serverSocket;
    static int port = 8080;

    static void setPort(int port) {
        if (port > 0) {
            SimpleWebServer.port = port;
        }
    }

    static void setBasePath(String basePath) {
        if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
            SimpleWebServer.basePath = basePath;
        }
    }

    public static void start() throws Exception {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }

    static class HttpRequestHandler implements Runnable {
        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                System.out.println(header);
                String filePath = basePath + header.split(" ")[1];
                System.out.println("path:" + filePath);
                out = new PrintWriter(socket.getOutputStream());

                if (filePath.endsWith("jpg") || filePath.endsWith("ico") || filePath.endsWith("gif")) {
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = in.read()) != -1) {
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length: " + array.length);
                    out.println("");
                    socket.getOutputStream().write(array, 0, array.length);
                } else {
                    filePath = filePath + "/index.html";
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.flush();
            } catch (FileNotFoundException e) {
                if (out != null) {
                    out.println("HTTP/1.1 404");
                    out.println("");
                    out.flush();
                }
            } catch (Exception e) {
                if (out != null) {
                    out.println("HTTP/1.1 500");
                    out.println("");
                    out.flush();
                }
            } finally {
                close(br, in, reader, out, socket);
            }
        }

        private void close(Closeable... closeables) {
            if (closeables == null) {
                return;
            }
            for (Closeable closeable : closeables) {
                if (closeable == null) {
                    continue;
                }
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
