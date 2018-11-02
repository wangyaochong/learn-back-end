import org.junit.Test;
import util.UtilDate;
import vo.UnixDateTimeRange;

import java.util.Date;

public class TestUtilDate {

    @Test
    public void test(){
        UnixDateTimeRange monthRange = UtilDate.getMonthRange(System.currentTimeMillis());
        System.out.println(new Date(monthRange.getStartDateTime()));
        System.out.println(new Date(monthRange.getEndDateTime()));
    }
}
