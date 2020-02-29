package 手写redis客户端.client;

import lombok.Data;
import 手写redis客户端.connection.Connection;

@Data
public class Client {
    Connection connection;

    public Client(String host, int port) {
        connection = new Connection();
        connection.setHost(host);
        connection.setPort(port);
    }

    public String set(final String key, final String value) {
        connection.sendCommand(key, value);
        return null;
    }

    public String get(final String key) {
        return null;
    }
}
