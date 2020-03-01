package 测试.抓包;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RedisHackServer {
    public static void main(String[] args) throws IOException {
/*
 先启动server监听，然后启动client连接，可以看到请求的协议字符串
 *2
 $3
 GET
 $6
 monkey
 以上就是resp协议的内容
 */
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            Socket accept = serverSocket.accept();
            byte[] bytes = new byte[1024];
            int read = accept.getInputStream().read(bytes);
            if (read > 0) {
                System.out.println("服务启动成功");
                System.out.println(new String(bytes));
            }
        }
    }
}
