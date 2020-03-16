package z师世伟.phoneNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author wangyaochong
 * @date 2020/3/16 10:33
 */
public class PhoneNumber {

    public static void main(String[] args) {
        List<Long> phoneNumber = new ArrayList<>();
        for (long start = 18591896600L ; start <= 18591896699L ; start++) {
            phoneNumber.add(start);
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            List<Long> random5Number = getRandom5Number(phoneNumber);
            StringBuilder phoneListString = new StringBuilder();
            for (int i = 0 ; i < random5Number.size() ; i++) {
                Long aLong = random5Number.get(i);
                phoneListString.append(i + 1).append("、").append(aLong).append("   ");
            }
            System.out.println("号码列表：" + phoneListString.toString());
            System.out.print("请选择数字：");
            String s = scanner.nextLine();
            int i = Integer.parseInt(s.replaceAll(" ", ""));
            if (i >= 5 || i < 0) {
                System.out.println("数字范围不对，请输入[1-5]");
            } else {
                Long remove = random5Number.remove(i);
                System.out.println("已选择->" + remove);
            }
            phoneNumber.addAll(random5Number);
        }
    }

    public static List<Long> getRandom5Number(List<Long> list) {
        List<Long> result = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i++) {
            Long one = list.get(new Random().nextInt(list.size()));
            result.add(one);
        }
        return result;
    }
}

