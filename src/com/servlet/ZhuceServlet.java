package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

public class ZhuceServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");//jsp页面传递过来的参数
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String home = request.getParameter("home");
        String info = request.getParameter("info");

        User user = new User();// 实例化User对象，组装属性
        user.setName(name);
        user.setHome(home);
        user.setInfo(info);
        user.setPwd(pwd);
        user.setSex(sex);

        UserDao ud = new UserDaoImpl();
        int resultInt = ud.register(user);
        response.getWriter().println(resultInt);
        if (resultInt == 1) {
            request.setAttribute("username", name); //向request域中放置参数
            request.setAttribute("userPwd", pwd);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        if (resultInt == 2) {
            request.setAttribute("xiaoxi", "用户名重复请重新填写"); //向request域中放置参数
            request.setAttribute("userName", name);
            request.setAttribute("userPwd", pwd);
            request.setAttribute("userSex", sex);
            request.setAttribute("userHome", home);
            request.setAttribute("userInfo", info);
            request.getRequestDispatcher("/zhuce.jsp").forward(request, response);
        }
    }
}
