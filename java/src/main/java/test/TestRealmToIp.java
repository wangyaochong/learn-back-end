package test;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TestRealmToIp {

    @Test
    public void test() throws UnknownHostException {
        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress inetAddress : allByName) {
            System.out.println(inetAddress.getHostAddress());
        }

         InetAddress[] allByName2 = InetAddress.getAllByName("182.61.200.6");
        for (InetAddress inetAddress : allByName2) {
            System.out.println(inetAddress.getHostAddress());
        }
    }
}
