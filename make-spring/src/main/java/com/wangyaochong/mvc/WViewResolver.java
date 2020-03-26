package com.wangyaochong.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Locale;

/**
 * @author wangyaochong
 * @date 2020/3/25 22:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WViewResolver {
    String webAppRoot;
    String prefix;
    String suffix;

    public WView resolveViewName(String viewName, Locale locale) throws Exception {
        if (null == viewName || "".equals(viewName.trim())) {
            return null;
        }
        viewName = viewName.endsWith(suffix) ? viewName : (viewName + suffix);
        File templateFile = new File((webAppRoot + "/" + prefix + "/" + viewName).replaceAll("/+", "/"));
        WView view = new WView();
        view.setViewFile(templateFile);
        return view;
    }


}
