package wangyaochong;

import org.apache.zookeeper.*;

import java.io.IOException;

public class DistributeServer {
    public static void main(String[] args) throws InterruptedException, KeeperException, IOException {
        DistributeServer server = new DistributeServer();
        //1. 连接zookeeper集群
        server.getConnect();
        //2. 注册节点
        server.register(args[0]);
        server.business();
        //3. 业务逻辑处理
    }

    private void register(String hostName) throws KeeperException, InterruptedException {
        String result = zkClent.create("/servers/server", hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("hostName" + "is online");
    }

    private int sessionTimeout = 2000;
    private String connectString = "localhost:2182,localhost:2183,localhost:2184";
    private ZooKeeper zkClent = null;

    private void getConnect() throws IOException {
        zkClent = new ZooKeeper(connectString, sessionTimeout, (WatchedEvent watchedEvent) -> {
        });
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }


}
