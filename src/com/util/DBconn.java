package com.util;
/**
 * @deprecated this is sql operate
 */

import java.sql.*;

public class DBconn {
    static String url = "jdbc:mysql://localhost:3306/test?useunicuee=true& characterEncoding=utf8";
    static String username = "root";
    static String password = "0825";
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    public static void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.print("数据库连接失败");
            e.printStackTrace();
        }
    }

    public static int addUpDel(String sql) {
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.print("sql数据库增删改异常");
            e.printStackTrace();
        }
        return i;
    }

    public static ResultSet selectSql(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
        } catch (SQLException e) {
            System.out.print("sql数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }

    public static void closeConn() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.print("数据库关闭异常");
            e.printStackTrace();
        }
    }

}
