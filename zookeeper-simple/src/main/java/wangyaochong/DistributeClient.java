package wangyaochong;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DistributeClient {
    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        DistributeClient client = new DistributeClient();
        client.connect();
        client.getChildren();
        client.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClent.getChildren("/servers", true);
        List<String> hostIps = new ArrayList<>();
        for (String child : children) {
            try {
                byte[] hostIp = zkClent.getData("/servers/" + child, false, null);
                hostIps.add(new String(hostIp));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println(hostIps);
    }


    private int sessionTimeout = 2000;
    private String connectString = "127.0.0.1:2182,127.0.0.1:2183,127.0.0.1:2184";
    private ZooKeeper zkClent = null;

    private void connect() throws IOException {
        zkClent = new ZooKeeper(connectString, sessionTimeout, (WatchedEvent watchedEvent) -> {
            try {
                getChildren();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
