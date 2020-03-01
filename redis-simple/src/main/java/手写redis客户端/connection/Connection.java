package 手写redis客户端.connection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import 手写redis客户端.protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Connection {
    private Socket socket;
    private String host;
    private int port;
    private InputStream inputStream;
    private OutputStream outputStream;

    private void connect() {
        try {
            if (socket == null) {
                socket = new Socket(host, port);
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection sendCommand(redis.clients.jedis.Protocol.Command command, byte[]... args) {
        connect();
        Protocol.sendCommand(outputStream, command, args);
        return this;
    }

    public String getResponse() {
        byte[] bytes = new byte[1024];
        int read = 0;
        try {
            read = socket.getInputStream().read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (read != -1) {
            return new String(bytes);
        }
        throw new RuntimeException("响应异常");

    }
}
