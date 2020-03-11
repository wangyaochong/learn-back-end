package wuhan;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.ArrayList;
import java.util.List;

public class ExcelDate {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:/date.xls"), 0);
        reader.readAsText(true);
        reader.setIgnoreEmptyRow(false);
        List<List<Object>> read = reader.read();
        reader.close();
        ExcelWriter writer = ExcelUtil.getWriter(FileUtil.file("D:/date2.xls"));

        List<List<String>> result = new ArrayList<>();
        for (List<Object> objects : read) {
            result.add(new ArrayList<>());
            if (objects.size() == 0) {
                result.get(result.size() - 1).add("");
                result.get(result.size() - 1).add("");
                result.get(result.size() - 1).add("");
                continue;
            }
            for (Object object : objects) {
                if (object != null) {
                    String s = object.toString();
                    s = s.replace("年", "-");
                    s = s.replace("月", "-");
                    s = s.replace("/", "-");
                    s = s.replace(".", "-");
                    s = s.replace("日", "");
                    String date = "";
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '-' || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                            date += s.charAt(i);
                        }
                    }
                    if (date.startsWith("10") || date.startsWith("11") || date.startsWith("12")) {
                        date = "2019-" + date;
                    }
                    if (date.startsWith("1-") || date.startsWith("01-")) {
                        date = "2020-" + date;
                    }
                    date = date.replace("-01-", "-1-");
                    date = date.replace("000000", "");
                    result.get(result.size() - 1).add(date);
                } else {
                    result.get(result.size() - 1).add("");
                }

            }

        }
        writer.write(result);
        writer.close();

    }
}
