package z师世伟.wuhan;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:/test.xls"), 0);
        reader.readAsText(true);
        reader.setIgnoreEmptyRow(false);
        List<List<Object>> read = reader.read();
        reader.close();
        ExcelWriter writer = ExcelUtil.getWriter(FileUtil.file("D:/test2.xls"));

        List<List<String>> result = new ArrayList<>();
        for (List<Object> objects : read) {
            result.add(new ArrayList<>());
            if (objects.size() == 0) {
                result.get(result.size() - 1).add("");
                result.get(result.size() - 1).add("");
                continue;
            }
            Object o = objects.get(0);
            result.get(result.size() - 1).add(o.toString());
            if (o.toString().contains("武汉")) {
                result.get(result.size() - 1).add("一类人员-武汉");
            } else if (o.toString().contains("湖北") && !o.toString().contains("武汉")) {
                result.get(result.size() - 1).add("一类人员-湖北");
            } else if (o.toString().contains("西安")) {
                result.get(result.size() - 1).add("二类人员");
            } else if (o.toString().contains("无")) {
                result.get(result.size() - 1).add(" ");
            } else if (!StringUtils.isBlank(o.toString())) {
                result.get(result.size() - 1).add("三类人员");
            } else {
                result.get(result.size() - 1).add(" ");
            }
        }
        writer.write(result);
        writer.close();
    }
}
