package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.util.DBconn;

public class UserDaoImpl implements UserDao {
    //注册
    public int register(User user) {
        int flag = 0;
        try {
            DBconn.init();
            ResultSet rs2 = DBconn.selectSql("select * from user where name = '" + user.getName() + "';");
            System.out.print(rs2);
            while (rs2.next()) {
                if (rs2.getString("name").equals(user.getName())) {
                    flag = 2;
                }
            }
            ;
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (flag != 2) {
            DBconn.init();
            int i = DBconn.addUpDel("insert into user(name,pwd,sex,home,info) values('" +
                    user.getName() + "','" + user.getPwd() + "','" + user.getSex() + "','" + user.getHome() + "','" + user.getInfo() + "')");
            if (i > 0) {
                flag = 1;
            }
        }
        return flag;
    }

    ;

    //登录
    public int login(String name, String pwd) {
        int flag = 0;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user where name='" + name + "' and pwd='" + pwd + "'");
            while (rs.next()) {
                if (rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)) {
                    flag = 1;
                }
            }
            ResultSet rs2 = DBconn.selectSql("select * from user where name = '" + name + "';");
            while (rs2.next()) {
                if (!rs2.getString("pwd").equals(pwd)) {
                    flag = 2;
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //返回所有用户的合计
    public List<User> getUserAll() {
        List<User> list = new ArrayList<User>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setHome(rs.getString("home"));
                user.setInfo(rs.getString("info"));
                list.add(user);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    ;

    //修改用户
    public boolean update(int id, String name, String sex, String info, String home, String pwd) {
        boolean flag = false;
        DBconn.init();
        String sql = "update user set name ='" + name
                + "' , pwd ='" + pwd
                + "' , sex ='" + sex
                + "' , home ='" + home
                + "' , info ='" + info + "' where id = " + id;
        int i = DBconn.addUpDel(sql);

        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    ;

    //删除用户
    public boolean delete(int id) {
        boolean flag = false;
        DBconn.init();
        int i = 0;
        i = DBconn.addUpDel("delete from user where id = " + id);
        if (i > 0) {
            flag = true;
        }
        return flag;
    }

    ;

}

