package util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import vo.UnixDateTimeRange;

import java.text.ParseException;
import java.util.Date;

public class UtilDate {

    /**
     * @param dateTime 到毫秒的时间戳
     * @return 返回该时间戳当月的时间范围
     */
    public static UnixDateTimeRange getMonthRange(long dateTime) {
        String format = DateFormatUtils.format(dateTime, "yyyy-MM");
        try {
            Date dateMonth = DateUtils.parseDate(format, "yyyy-MM");
            Date dateNextMonth = DateUtils.addMonths(dateMonth, 1);
            return new UnixDateTimeRange(dateMonth.getTime(), dateNextMonth.getTime() - 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("解析日期出错！");
    }

    /**
     * @param dateTime 到毫秒的时间戳
     * @return 返回该时间戳当日的时间范围
     */
    public static UnixDateTimeRange getDayRange(long dateTime) {
        String format = DateFormatUtils.format(dateTime, "yyyy-MM-dd");
        try {
            Date dateDay = DateUtils.parseDate(format, "yyyy-MM-dd");
            Date dateNextDay = DateUtils.addDays(dateDay, 1);
            return new UnixDateTimeRange(dateDay.getTime(), dateNextDay.getTime() - 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("解析日期出错！");
    }

}
