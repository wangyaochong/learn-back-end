package web.websocket;

import web.anno.MyRequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wangyaochong
 * @date 2020/3/29 14:43
 */

public class HelloController {
    @MyRequestMapping("hello.do")
    public String mvc(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println(id);
        System.out.println(request.getServletContext().getRealPath("/"));
        return "hello.html";
    }
}
