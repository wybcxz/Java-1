package com.it.model;

/**
 *登录信息表
 */
public class Account {

    //属性
    private int id;
    private static String admin;
    private static String pwd;




    //访问方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getAdmin() {
        return admin;
    }

    public static void setAdmin(String admin) {
        Account.admin = admin;
    }

    public static String getPwd() {
        return pwd;
    }

    public static void setPwd(String pwd) {
        Account.pwd = pwd;
    }


}
