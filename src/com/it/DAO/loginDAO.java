package com.it.DAO;

import com.it.jdbc.DBConnection;
import com.it.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 登陆验证 --
 * 值由dl传入
 * 查找是否有符合的数据 用于登录验证
 *
 */
public class loginDAO {

/*
ps：这里码两种解决方法
注释掉的为第二种
 */
    //1.定义方法 传入输入的账号密码数据
    public boolean  account(Account account) {

        //2.获取数据库连接
        Connection conn = DBConnection.getConn();


        String sql = "select * from account where admin=? and pwd=?";


        try {

            //4.预编译SQL
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,account.getAdmin());
            ps.setString(2,account.getPwd());

            //5.执行sql并保存结果
            ResultSet rs = ps.executeQuery();

            //6.读取符合sql语句的数据 有符合的数据返回true 否则返回false
            if (rs.next()){
                return true;
            }
            DBConnection.close(rs,ps,conn);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
            return false;

    }

    //第二种
//    public boolean  account(String admin,String password) {
//
//        //2.获取数据库连接
//        Connection conn = DBConnection.getConn();
//
//        //3.定义SQL语句
//        String sql = "select * from account where admin=" + admin + " and" + " pwd=" + password;
//
//
//
//
//        try {
//
//            //4.预编译SQL
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            //5.执行sql并保存结果
//            ResultSet rs = ps.executeQuery(sql);
//
//            //6.读取符合sql语句的数据 有符合的数据返回true 否则返回false
//            if (rs.next()){
//                return true;
//            }
//            DBConnection.close(rs,ps,conn);
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return false;
//        }
//        return false;
//    }


}
