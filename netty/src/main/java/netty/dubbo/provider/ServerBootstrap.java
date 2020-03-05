package netty.dubbo.provider;

import netty.dubbo.netty.NettyServer;

public class ServerBootstrap {
    public static void main(String[] args) throws InterruptedException {
        NettyServer.startServer0("127.0.0.1", 7000);
    }
}
