package 测试;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TestCluster {
    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis("www.wangyaochong.com", 6381);
//        jedis.set("a", "a234");
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("www.wangyaochong.com", 6381));
        nodes.add(new HostAndPort("www.wangyaochong.com", 6382));
        nodes.add(new HostAndPort("www.wangyaochong.com", 6383));
        nodes.add(new HostAndPort("www.wangyaochong.com", 6384));
        nodes.add(new HostAndPort("www.wangyaochong.com", 6385));
        nodes.add(new HostAndPort("www.wangyaochong.com", 6386));
        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("test", "testvalue");
        String test = cluster.get("test");
        cluster.close();
        System.out.println(test);
    }
}
