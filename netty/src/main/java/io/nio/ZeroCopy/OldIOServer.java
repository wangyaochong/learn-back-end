package io.nio.ZeroCopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldIOServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(7001);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            try {
                byte[] bytes = new byte[4096];
                int read = 1;
                while (read != -1) {
                    read = dataInputStream.read(bytes, 0, bytes.length);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
