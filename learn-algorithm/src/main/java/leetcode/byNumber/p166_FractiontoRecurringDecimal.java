package leetcode.byNumber;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class p166_FractiontoRecurringDecimal {

    public String fractionToDecimal(int nume, int deno) {
        long numerator = nume;
        long denominator = deno;
        if (numerator == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        result.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        if (numerator > denominator) {
            result.append(numerator / denominator);
            numerator = numerator % denominator;
        }
        if (numerator == 0) {
            return result.toString();
        }
        if (result.length() == 0 || result.toString().equals("-")) {
            result.append("0.");
        } else {
            result.append(".");
        }
        Map<Long, Integer> cache = new HashMap<>();
        long tmp;
        while (numerator != 0) {
            tmp = (numerator * 10) / denominator;
            Integer integer = cache.get(numerator);
            if (integer != null) {
                result.insert(integer, "(");
                result.append(")");
                return result.toString();
            }
            cache.put(numerator, result.length());
            result.append(tmp);
            numerator = (numerator * 10) % denominator;
        }
        return result.toString();
    }

    @Test
    public void test() {
        System.out.println(fractionToDecimal(0, 1));
    }

    @Test
    public void testFilter() {
        System.out.println(
                Stream.of(
                        new BigDecimal("0.1"),
                        new BigDecimal("10"),
                        new BigDecimal("100"),
                        new BigDecimal("0"),
                        new BigDecimal(-1), null)
                        .filter(e -> e != null && e.compareTo(BigDecimal.ZERO) > 0)
                        .collect(Collectors.toList()));
    }

    @Test
    public void testInteger() {
        System.out.println(new Integer(1) == new Integer(1));
    }


}
