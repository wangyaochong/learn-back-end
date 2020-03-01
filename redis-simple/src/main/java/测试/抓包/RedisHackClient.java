package 测试.抓包;


import redis.clients.jedis.Jedis;

public class RedisHackClient {
    public static void main(String[] args) {
        try (Jedis jedis = new Jedis("127.0.0.1", 8888)) {
            jedis.get("monkey");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
