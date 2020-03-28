package java8.functionalProgrammingCourse;


import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyaochong
 * @date 2020/3/29 05:35
 */
public class TestMyFunc {
    @FunctionalInterface
    interface MyFunc {
        Object call(String code , String date , String paramName );
    }

    public static void main(String[] args) {
        Map<String, MyFunc> funcMap = new HashMap<>();
        funcMap.put("ind_amount", (a, b, c) -> "get amount");
        funcMap.put("ind_open", (a, b, c) -> "get open");
        funcMap.put("ind_close", (a, b, c) -> "get close");

        System.out.println(funcMap.get("ind_amount").call("123", "3.17", "1"));
    }

    public Object getIndicatorValue(String tableName,String indicatorName,String code,String date){
        return null;
    }

}
