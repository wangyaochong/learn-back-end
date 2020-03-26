package com.wangyaochong.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangyaochong
 * @date 2020/3/25 22:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WView {
    String defaultContentType = "text/html;charset=utf-8";
    File viewFile;
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer sb = new StringBuffer();
        try (RandomAccessFile ra = new RandomAccessFile(this.viewFile, "r")) {
            String line;
            while ((null != (line = ra.readLine()))) {
                line = new String(line.getBytes("ISO-8859-1"), "utf-8");
                String p = "\\$\\{\\w+}";
                Pattern pattern = Pattern.compile(p);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String paramName = matcher.group();
                    paramName = paramName.replaceAll("\\$\\{|}", "");
                    Object paramValue = model.get(paramName);
                    if (null != paramValue) {
                        line = line.replaceFirst(p, paramValue.toString());
                    }
                }
                sb.append(line);
            }
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType(defaultContentType);
        response.getWriter().write(sb.toString());
        response.getWriter().close();
    }

    public static void main(String[] args) {
        Pattern compile = Pattern.compile("\\$\\{(\\w|[0-9])*}");
        String input = "${name}sss,${xxx},${ss999sssdfsxx},${sdf234asdf_sdf}";
        Matcher matcher = compile.matcher(input);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
            String s = group.replaceAll("\\$\\{|}", "");
            System.out.println(s);
            input = input.replaceFirst("\\$\\{\\w+}", s);
            System.out.println(input);
        }
    }
}
