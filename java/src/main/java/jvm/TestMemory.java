package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Test memory.
 *
 * @author wangyaochong
 * @date 2020 /3/15 15:08
 */


public class TestMemory {


    /**
     * -Xmx100m -Xms100m -XX:+PrintGCDetails
     * 以上java虚拟机参数可以打印jvm详细信息，还可以看到垃圾回收的详细过程
     */
    public static void main(String[] args) {
        int mb = 1024 * 1024;
        List<Object> list = new ArrayList<>();
        for (int i = 0 ; i < 1000000000 ; i++) {
            int[] temp = new int[10000000];
            list.add(temp);
        }
//        查看java虚拟机日志
        System.out.println(list);
        System.out.println("最大内存" + Runtime.getRuntime().maxMemory() / mb + "MB");
        System.out.println("当前总内存" + Runtime.getRuntime().totalMemory() / mb + "MB");
        System.out.println("-------------------");
    }
}
