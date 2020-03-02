package wangyaochong;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import wangyaochong.service.OrderService;

public class Main {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.initOrder("1");
        System.in.read(); // 按任意键退出
    }
}
