package 测试;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("a", "a234");
        System.out.println(jedis.get("a"));
//        List<Thread> threadList = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            threadList.add(new Thread(() -> {
//                secondKill(Thread.currentThread().getName() + Thread.currentThread().getId());
//            }));
//        }
//        for (Thread thread : threadList) {
//            thread.start();
//        }
    }

    public static void secondKill(String uid) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String format = String.format("if tonumber(redis.call('get','inventory'))>0 and redis.call('sismember','uidCache','%s')==0 " +
                "then  redis.call('decr' , 'inventory')   redis.call('sadd','uidCache','%s')  return 1 else return 0 end", uid, uid);
        Object eval = jedis.eval(format);
        if (eval.toString().equals("0")) {
            System.out.println("秒杀失败");
        } else {
            System.out.println("秒杀成功");
        }
    }

    public static void secondKillBad() {
        //由于事务失效，导致部分用户的点击失效，则可能导致100个用户秒杀100个商品，最后卖出的商品数量不足100的情况。
        //也就是可能导致商品少卖
//        jedis.watch("inventory");
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.watch("inventory");
        Transaction multi = jedis.multi();
        multi.decr("inventory");
        multi.sadd("cache", "cache");
        List<Object> exec = multi.exec();
        if (exec == null || exec.size() == 0) {
            System.out.println("秒杀失败");
        } else {
            System.out.println("秒杀成功");
        }
    }
}
