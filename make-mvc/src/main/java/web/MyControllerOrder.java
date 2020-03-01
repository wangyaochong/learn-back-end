package web;

import web.anno.MyRequestMapping;

import javax.servlet.http.HttpServletRequest;

public class MyControllerOrder {
    @MyRequestMapping("query.do")
    public void query(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("query.do, param=" + name);
    }

}
