package basic;

import java.util.Map;
import java.util.Properties;

/**
 * @author wangyaochong
 * @date 2020/3/26 17:49
 */
public class 时针重合 {
    public static void main(String[] args) {
        int fz = 0;
        int sz = 0;
        int meet = 0;
        while (sz <= 11) {
            fz = (fz + 1) % 60;
            if (fz == 0) {
                System.out.println("时=" + sz);
                sz++;
            }
            if (fz == sz) {
                meet++;
            }
        }
        System.out.println(meet);
        Map<String, String> getenv = System.getenv();
        System.out.println(getenv);
        Properties properties = System.getProperties();
        System.out.println(properties);
    }
}
