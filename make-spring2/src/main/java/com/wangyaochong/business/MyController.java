package com.wangyaochong.business;

import com.wangyaochong.anno.WAutowired;
import com.wangyaochong.anno.WController;
import com.wangyaochong.anno.WRequestMapping;
import com.wangyaochong.anno.WRequestParam;
import com.wangyaochong.business.service.QueryService;
import com.wangyaochong.mvc.WModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    @WRequestMapping("/page")
    public WModelAndView page(@WRequestParam("name") String name) {
        WModelAndView modelAndView = new WModelAndView();
        Map<String, Object> model = new HashMap<>();
        model.put("name", name);
        modelAndView.setModel(model);
        modelAndView.setViewName("page.html");
        return modelAndView;
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
