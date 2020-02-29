package 手写redis客户端.connection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
            socket = new Socket(host, port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection sendCommand(String key, String value) {
        connect();

        return this;
    }
}
