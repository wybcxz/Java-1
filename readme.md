# idea JFormDesigner布局+ Java Swing 完成JDBC+Mysql增删改查及登录+jar包的实现

网上搜到很多零散的Javaswing实现数据库增删改查，但是加上登录的不多，我拼拼凑凑整合了一下。

## 思路：

首先要下载Mysql驱动导入，利用JFormDesigner实现可视化窗口操作，有登录页面，信息页面，修改信息界面，添加信息界面；然后添加对应的逻辑代码。

## 预览：

### 登录界面：



<img src="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/c78f15ab3fb9b628e2f6cefa22f3203e12dbdaed9cbb3cf9ea0cf8a9d397f10a4397e9c3682b40e6539b7fb74d5c539e?pictype=scale&from=30113&version=3.3.3.3&fname=%E7%99%BB%E5%BD%95%E7%95%8C%E9%9D%A2.png&size=750" alt="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/c78f15ab3fb9b628e2f6cefa22f3203e12dbdaed9cbb3cf9ea0cf8a9d397f10a4397e9c3682b40e6539b7fb74d5c539e?pictype=scale&from=30113&version=3.3.3.3&fname=%E7%99%BB%E5%BD%95%E7%95%8C%E9%9D%A2.png&size=750" style="zoom:50%;" />

### 信息界面：

<img src="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/4f465680f78597145fb6b683b52f0e4ef7efb19bf014b31e7f51a57bca56d0a852bbe71325427ec2ddbe4016413bdebd?pictype=scale&from=30113&version=3.3.3.3&fname=%E4%BF%A1%E6%81%AF%E7%95%8C%E9%9D%A2.png&size=750" style="zoom:50%;" />

### 修改信息界面：

<img src="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/43c2fde59da3edab5240a19ff06a64155054b3c40d5c532dbcfbd9cd988c01e00bef0d0805733ccc5b514110de2ef3d1?pictype=scale&from=30113&version=3.3.3.3&fname=%E4%BF%AE%E6%94%B9%E7%95%8C%E9%9D%A2.png&size=750" style="zoom:50%;" />

### 添加信息界面：

<img src="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/37992a20ffa0bf2ef08e9f2043a27f12d2e90bc1a76ec04460a66ddc4d6899ccc4611a2f58915d53ba50f769d60210e6?pictype=scale&from=30113&version=3.3.3.3&fname=%E6%B7%BB%E5%8A%A0%E7%95%8C%E9%9D%A2.png&size=750" style="zoom:50%;" />

## 目录结构：

<img src="https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/98461dde8ff7ef59a53bd3351bf08eb4c618b4b5331efb7783fba018e2ec09e90483d1dd5b285c60931d1c8864b1e791?pictype=scale&from=30113&version=3.3.3.3&fname=%E7%9B%AE%E5%BD%95.png&size=750" style="zoom:50%;" />

## 准备工作：

#### JFormDesigner插件：

#### Mysql驱动包：

## 实施：

### 1-结构：

Java：路径src.com.it下建3个文件夹，分别是dao、jdbc、model；4个页面，分别是Login、MainPage、InsertPage、UpdatePage。

- jdbc：文件夹下的DBConnection用于连接数据库的准备工作
- model：一张表建一个类，Account是登陆时用于验证的表，Student是用于操作学生信息的表。
- dao：对应类的数据库操作实现，loginDAO用于实现登录页面验证操作；studentDAO用于实现Student的增删改查。

SQL：有两张表，显而易见，Student和Account

Mysql驱动：mysql-connector-java-xx.jar 

### 2-源码：

#### sql语句：

Student

```mysql
/*
 Navicat Premium Data Transfer

 Source Server         : text
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : db3

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 15/09/2022 18:00:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stuid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int(3) NOT NULL,
  `gender` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `height` decimal(6, 2) NULL DEFAULT NULL,
  `classID` int(11) NOT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`stuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2, '张三1', 20, '女', 150.00, 1, '2022-02-02 00:00:00');
INSERT INTO `student` VALUES (4, '王小明1', 23, '男', 173.00, 2, '2022-01-04 00:00:00');
INSERT INTO `student` VALUES (5, '陈天明1', 19, '男', 163.20, 2, '2022-05-03 00:00:00');
INSERT INTO `student` VALUES (6, '陆少明', 20, '男', 158.50, 1, '2022-06-21 00:00:00');
INSERT INTO `student` VALUES (7, '陆明1', 20, '男', 158.50, 1, '2022-06-21 00:00:00');
INSERT INTO `student` VALUES (8, '张三', 10, '男', 170.00, 10, '2022-06-15 22:06:15');
INSERT INTO `student` VALUES (12, '张三1', 20, '女', 150.00, 1, '2022-06-15 22:38:31');
INSERT INTO `student` VALUES (14, '张三', 10, '男', 170.00, 10, '2022-06-15 22:47:53');
INSERT INTO `student` VALUES (15, '张三', 10, '男', 170.00, 10, '2022-06-15 22:52:09');
INSERT INTO `student` VALUES (17, '小花', 10, '男', 170.00, 10, '2022-09-04 14:28:45');
INSERT INTO `student` VALUES (19, '张三', 10, '男', 170.00, 10, '2022-09-04 14:35:06');
INSERT INTO `student` VALUES (20, '李四', 10, '男', 170.00, 10, '2022-09-04 14:35:34');
INSERT INTO `student` VALUES (21, '王五', 10, '男', 170.00, 10, '2022-09-04 15:18:36');
INSERT INTO `student` VALUES (29, '赵六', 12, '12', 1.00, 12, '2022-09-05 00:01:33');
INSERT INTO `student` VALUES (38, '小白', 12, '女', 123.00, 1, '2022-09-05 16:16:57');
INSERT INTO `student` VALUES (40, '小李', 19, '女', 170.00, 1, '2022-09-15 17:40:45');

SET FOREIGN_KEY_CHECKS = 1;

```

Account

```mysql
/*
 Navicat Premium Data Transfer

 Source Server         : text
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : db3

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 15/09/2022 18:01:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pwd` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'admin', 123456);
INSERT INTO `account` VALUES (2, 'abcd', 123456);

SET FOREIGN_KEY_CHECKS = 1;

```



#### Java代码：



##### 1.DBConnection

首先要连接数据库才能完成增删改查

```java
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

```

##### 2.Student

一张表对应一个model下的类

```java
package com.it.model;

import java.sql.Date;

/**
 * student信息表
 */
public class Student {
    //属性
    private int stuid;
    private String name;
    private int age;
    private String gender;
    private double height;
    private int classID;
    private Date createtime;

    //访问方法
    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
```

##### 3.studentDAO

对应实现Student类的增删改查操作

```java
package com.it.DAO;

import com.it.jdbc.DBConnection;
import com.it.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


/**
 * 学生列表的操作
 * 即 -- 增删改查
 */

public class studentDAO {


    /**
     * 增 --> 新增数据
     * Student:传入的学生信息
     */

    //1.定义一个方法 学生类传参 返回布尔值判断true或false
    public boolean add(Student stu){

        //2.获取数据库连接
        Connection conn = DBConnection.getConn();
        //3.定义SQL语句
        String sql = "insert into student values(null,?,?,?,?,?,now())";

        try {
            //4.预编译sql语句
            PreparedStatement ps = conn.prepareStatement(sql);

            //5.填充设置占位符
            ps.setString(1,stu.getName());
            ps.setInt(2,stu.getAge());
            ps.setString(3,stu.getGender());
            ps.setDouble(4,stu.getHeight());
            ps.setInt(5,stu.getClassID());

            //6.执行sql并返回布尔值
            boolean b = ps.executeUpdate() > 0;

            //7.释放资源
            DBConnection.close(null,ps,conn);
            return b;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    /**
     * 删 --> 删除数据
     *stuid：根据id删除对应数据
     */

    //1.定义方法 根据id删除对应数据 返回布尔值
    public boolean delete(String stuid){

        //1.获取数据库连接
        Connection conn = DBConnection.getConn();

        //2.定义SQL语句
        String sql = "delete from student where stuid=?";

        try {

            //3.预编译SQL
            PreparedStatement ps = conn.prepareStatement(sql);

            //4.设置占位符数据
            ps.setString(1,stuid);

            //5.执行SQL并返回布尔值
            boolean b = ps.executeUpdate() > 0;

            //6.释放资源
            DBConnection.close(null,ps,conn);

            return b;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 改 --> 更新数据
     *stu:输入的学生信息
     */

    //1.定义方法 学生信息传参 返回布尔值
    public boolean update(Student stu){

        //2.获取数据库连接
        Connection conn = DBConnection.getConn();

        //3.定义SQL语句
        String sql = "update student set name=?,age=?,gender=?,height=?,classID=? where stuid=?";

        try {
            //4.预编译SQL
            PreparedStatement ps = conn.prepareStatement(sql);

            //5.设置占位符数据
            ps.setString(1, stu.getName());
            ps.setInt(2, stu.getAge());
            ps.setString(3, stu.getGender());
            ps.setDouble(4, stu.getHeight());
            ps.setInt(5, stu.getClassID());
            ps.setInt(6,stu.getStuid());

            //6.执行sql 返回布尔值
            boolean b = ps.executeUpdate() > 0;
            DBConnection.close(null,ps,conn);

            return b;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 查 --> 查询单条数据
     *stuid：根据id查询数据
     */

    //1.定义方法 传入id 返回布尔值
    public Student query(int stuid){

        //2.获取数据库连接
        Connection conn = DBConnection.getConn();

        //2.定义SQL语句
        String sql = "select * from student where stuid=?";
        try {

            //3.预编译SQL
            PreparedStatement ps = conn.prepareStatement(sql);

            //4.设置占位符数据
            ps.setInt(1,stuid);

            //5.执行SQL语句 并保存结果
            ResultSet rs = ps.executeQuery();

            //6.实例化学生对象返回
            Student s = new Student();

            //7.读取rs并设置到学生对象
            while (rs.next()){
                s.setStuid(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setAge(rs.getInt(3));
                s.setGender(rs.getString(4));
                s.setHeight(rs.getDouble(5));
                s.setClassID(rs.getInt(6));
                s.setCreatetime(rs.getDate(7));

                //释放资源
                DBConnection.close(rs,ps,conn);
                return s;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    /**
     * 查 --> 查询全部数据
     *模糊查询
     */

    //1.定义方法 传入数据
    public Vector<Vector<String>> getAll(String keyword){

        //2.获取数据库连接
        Connection conn = DBConnection.getConn();

        //3.定义sql语句
        String sql = "select * from student";

        //4.当传入数据不为null时，拼接sql语句
        if(keyword != null) {
            sql += " where name like '%"+keyword+"%'";
        }

        try {

            //5.预编译sql
            PreparedStatement ps = conn.prepareStatement(sql);

            //6.执行sql并保存结果
            ResultSet rs = ps.executeQuery();

            //7.实例化Vector
            Vector<Vector<String>> list = new Vector<Vector<String>>();

            //8.读取rs 并添加到list
            while (rs.next()){
                Vector<String> s = new Vector<String>();
                s.add(rs.getString(1));
                s.add(rs.getString(2));
                s.add(rs.getString(3));
                s.add(rs.getString(4));
                s.add(rs.getString(5));
                s.add(rs.getString(6));
                s.add(rs.getString(7));
                list.add(s);


            }

            //释放资源
            DBConnection.close(rs,ps,conn);

           return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
```

##### 4.Account

另一张表，用于登录验证数据库账号密码

```java
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
```

##### 5.accountDAO

```java
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



}
```

#### Swing窗体开发：

这部分不贴了，见源码即可！



我遇到的一些问题：

1.JFormDesigner编辑好界面然后修改了逻辑代码之后不要再次修改可视化界面了，因为一修改代码全部复位成原样了，我也不知道为什么。。。

2.编写代码的时候导入包的时候注意导入sql的包，不要导成util的了。

