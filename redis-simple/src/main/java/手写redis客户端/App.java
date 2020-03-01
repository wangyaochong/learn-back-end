package 手写redis客户端;

import redis.clients.jedis.Jedis;

public class App {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("test", "test");
        String test = jedis.get("test");
        System.out.println(test);
    }

}
