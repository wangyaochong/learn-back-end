package io.qqClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_BIO {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8080));
        System.out.println("waiting connection");
        Socket accept = serverSocket.accept();//会阻塞
        while (true) {
            System.out.println("connected...");
            byte[] bytes = new byte[1024];
            System.out.println("reading");
            int read = accept.getInputStream().read(bytes);//会阻塞
            System.out.println("read finished");
            String content = new String(bytes, 0, read);
            System.out.println(content);
        }
    }
}
