//package web;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(value = "/index",loadOnStartup = 1)
//public class IndexServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("get 方法");
//        super.doGet(req, resp);
//    }
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        System.out.println("IndexServlet初始化了");
//    }
//}
