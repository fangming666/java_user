package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
    public int login(String name,String pwd);//登录
    public int register(User user); //注册
    public List<User> getUserAll(); //返回用户信息集合
    public boolean delete(int id);//根据ID删除用户
    public boolean update(int id,String name,String pwd,String sex,String info,String home); //定义用户的信息
}
