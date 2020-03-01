package 手写redis客户端.client;

import lombok.Data;
import redis.clients.jedis.Protocol;
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
        Connection connection = this.connection.sendCommand(Protocol.Command.SET, key.getBytes(), value.getBytes());
        return connection.getResponse();
    }

    public String get(final String key) {
        Connection connection = this.connection.sendCommand(Protocol.Command.GET, key.getBytes());
        return connection.getResponse();
    }
}
