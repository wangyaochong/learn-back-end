package io.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestConnection {
    public static void main(String[] args) {
//        System.out.println(pintIp(""));
        System.out.println(telnetport("127.0.0.1", 8080));
    }

    public static boolean pintIp(String ip) throws IOException {
        return InetAddress.getByName(ip).isReachable(5000);
    }
    public static boolean telnetport(String ip,Integer port){
        Socket connect = new Socket();
        boolean res = false;
        try {
            connect.connect(new InetSocketAddress(ip, port), 5000);//建立连接
            //能telnet通返回true，否则返回false
            res = connect.isConnected();//通过现有方法查看连通状态
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("false");
            }
        }
        return res;
    }
}
