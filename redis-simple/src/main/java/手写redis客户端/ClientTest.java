package 手写redis客户端;

import 手写redis客户端.client.Client;

public class ClientTest {
    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 6379);
        String result = client.set("testClient", "testValue");
        System.out.println(result);
        result = client.get("testClient");
        System.out.println(result);
    }
}
