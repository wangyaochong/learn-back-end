package wangyaochong;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestZookeeper {
    /**
     * 注意这个值不能有任何空白字符
     */
//    private String connectString = "localhost:2182,localhost:2183,localhost:2184";
    private String connectString = "wangyaochong:2181,wangyaochong:2182,wangyaochong:2183";
    /**
     * 如果这个值太小，可能会丢失连接
     */
    private int sessionTimeout = 5000;
    private ZooKeeper zkClent = null;

    @Before
    public void init() throws IOException, InterruptedException {
        zkClent = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> children = null;
                try {
                    children = zkClent.getChildren("/humanss", true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (String child : children) {
                    System.out.println(child);
                }
            }
        });
        System.out.println("hello");
    }

    @Test//创建节点
    public void createNode() throws KeeperException, InterruptedException {
        String path = zkClent.create("/humanss", "jobs".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }

    @Test//获取子节点并监控数据
    public void getDataAndWatch() throws KeeperException, InterruptedException {
        List<String> children = zkClent.getChildren("/humanss", true);
        for (String child : children) {
            System.out.println(child);
        }
        Thread.sleep(Long.MAX_VALUE);
        return;
    }

    @Test//判断节点是否存在
    public void testExist() throws KeeperException, InterruptedException {
        Stat exists = zkClent.exists("/human", false);
        System.out.println(exists);
    }

}
