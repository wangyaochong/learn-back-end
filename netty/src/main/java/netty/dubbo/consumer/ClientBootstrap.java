package netty.dubbo.consumer;


import lombok.extern.slf4j.Slf4j;
import netty.dubbo.netty.NettyClient;
import netty.dubbo.publicinterface.HelloService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ClientBootstrap {
    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) {
        NettyClient consumer = new NettyClient();
        HelloService service = (HelloService) consumer.getBean(HelloService.class, providerName);
        String hello = service.hello("HelloService#hello#你好 dubbo");
        System.out.println("result=" + hello);
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            threadList.add(new Thread(() -> {
                String res = service.hello("HelloService#hello#你好 dubbo->" + finalI);
                log.info("发送" + finalI + ",收到" + res);
            }));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
    }
}
