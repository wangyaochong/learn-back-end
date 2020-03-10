import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestReturnValue {

    @Test
    public void test() {
    }

    public String method() {
        return "xxx";
    }

    @Test
    public void testBigDecimal() {
        List<BigDecimal> list = new ArrayList<>(Arrays.asList(BigDecimal.valueOf(1.2), BigDecimal.valueOf(2.3), BigDecimal.valueOf(1.5)));
        list.sort((a, b) -> (b.compareTo(a)));
        System.out.println(list);
    }

}
