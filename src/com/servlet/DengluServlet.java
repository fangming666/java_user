package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class DengluServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"); //获得jsp页面传递过来的数据
        String pwd = request.getParameter("pwd");
        UserDao ud = new UserDaoImpl();
        int resultInt = ud.login(name, pwd);
        if (resultInt == 1) {
            request.setAttribute("xiaoxi", "欢迎用户" + name);//向request域中放置信息
            request.getRequestDispatcher("/success.jsp").forward(request, response);//转发到成功的页面
        } else if (resultInt == 2) {
            request.setAttribute("pwdDanger", "密码错误");//向request域中放置信息
            request.setAttribute("Dangername", name);
            request.setAttribute("Dangerpwd", pwd);
            request.getRequestDispatcher("/login.jsp").forward(request, response);//转发到登录页面的页面
        } else {
            request.setAttribute("userDanger", "账号错误请重新登录");//向request域中放置信息
            request.setAttribute("Dangername", name);
            request.setAttribute("Dangerpwd", pwd);
            request.getRequestDispatcher("/login.jsp").forward(request, response);//转发到登录的页面
        }
    }
}
