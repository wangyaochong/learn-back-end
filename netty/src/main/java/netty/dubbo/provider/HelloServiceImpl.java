package netty.dubbo.provider;

import netty.dubbo.publicinterface.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String message) {
        System.out.println("收到客户端消息，message=" + message);
        if (message != null) {
            return "你好客户端，我已经收到你的消息，消息=" + message;
        }
        return "你好客户端，我已经收到消息";
    }
}
