package com.it.jdbc;

import java.sql.*;

/**
 * 驱动连接
 *
 */
public class DBConnection {
    //1.定义
    //驱动：之前用的是com.mysql.jdbc.Driver 现在新的加上了cj 不会出现警告
    public final static String driver = "com.mysql.cj.jdbc.Driver";
    //地址：最后设置成自己的数据库名称
    public final static String url = "jdbc:mysql://localhost:3306/db3";
    //用户 and 密码
    public final static String user = "root";
    public final static String pwd = "123456";



    //2.加载jdbc驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //3.连接mysql的连接对象
    public static Connection getConn(){
        try {
            return DriverManager.getConnection(url,user,pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    //4.关闭连接，释放资源
    public static void close(ResultSet rs, PreparedStatement ps,Connection conn){

            try {
                if (rs != null){
                rs.close();
                }if (ps != null){
                    ps.close();
                }if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    //验证jdbc类的使用
    public static void main(String[] args) {
        System.out.println(getConn());
    }

}
