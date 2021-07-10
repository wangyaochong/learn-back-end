package com.example.rocketmq.order;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class OrderStep {
    int orderId;
    String desc;

    public static List<OrderStep> buildOrders() {
        List<OrderStep> orderList = new ArrayList<>();
        OrderStep step1 = new OrderStep();
        step1.setOrderId(1039);
        step1.setDesc("创建");
        orderList.add(step1);

        step1 = new OrderStep();
        step1.setOrderId(7235);
        step1.setDesc("创建");
        orderList.add(step1);


        step1 = new OrderStep();
        step1.setOrderId(1065);
        step1.setDesc("创建");
        orderList.add(step1);

        step1 = new OrderStep();
        step1.setOrderId(1039);
        step1.setDesc("付款");
        orderList.add(step1);

        step1 = new OrderStep();
        step1.setOrderId(1065);
        step1.setDesc("付款");
        orderList.add(step1);

        step1 = new OrderStep();
        step1.setOrderId(1039);
        step1.setDesc("推送");
        orderList.add(step1);

        step1 = new OrderStep();
        step1.setOrderId(7235);
        step1.setDesc("付款");
        orderList.add(step1);

        step1 = new OrderStep();
        step1.setOrderId(7235);
        step1.setDesc("推送");
        orderList.add(step1);

        step1 = new OrderStep();
        step1.setOrderId(7235);
        step1.setDesc("完成");
        orderList.add(step1);

        step1 = new OrderStep();
        step1.setOrderId(1039);
        step1.setDesc("完成");
        orderList.add(step1);

        return orderList;
    }
}
