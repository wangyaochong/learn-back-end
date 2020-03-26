package com.wangyaochong.business;

import com.wangyaochong.anno.WAutowired;
import com.wangyaochong.anno.WController;
import com.wangyaochong.anno.WRequestMapping;
import com.wangyaochong.anno.WRequestParam;
import com.wangyaochong.mvc.WModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangyaochong
 * @date 2020/3/26 21:57
 */
@WController
@WRequestMapping("/query")
public class MyController {
    @WAutowired
    QueryService service;

    @WRequestMapping("/query")
    public WModelAndView query(@WRequestParam("name") String name, HttpServletResponse response) {
        String query = service.query(name);
        return out(response, query);
    }

    WModelAndView out(HttpServletResponse response, String str) {
        try {
            response.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
