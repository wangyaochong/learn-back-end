package web;

import web.anno.MyRequestMapping;
import web.anno.MyResponseBody;
import web.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyController {

    @MyRequestMapping("login.do")
    @MyResponseBody
    public Object login(HttpServletRequest request, String test, User user) {
        System.out.println("login.do, test=" + test + ",user=" + user);
        return user;
    }

    @MyRequestMapping("register.do")
    public void register(HttpServletResponse response, HttpServletRequest request) {
        System.out.println("register.do, param=");
    }

    @MyRequestMapping("del.do")
    public void del() {
        System.out.println("del");
    }

    @MyRequestMapping("mvc.do")
    public String mvc(HttpServletRequest request) {
        System.out.println(request.getServletContext().getRealPath("/"));
        return "mvc.html";
    }
}
