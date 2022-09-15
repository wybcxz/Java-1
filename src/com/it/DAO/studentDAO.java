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


//    //新增 -- 测试类
//    public static void main(String[] args) {
//        Student stu = new Student();
//        stu.setName("");
//        stu.setAge(10);
//        stu.setClassID(10);
//        stu.setHeight(170);
//        stu.setGender("男");
//
//        studentDAO studentDAO = new studentDAO();
//        if(studentDAO.add(stu)){
//            System.out.println("新增学生成功！");
//        }else {
//            System.out.println("新增学生失败！");
//        }



//
//        //更新 -- 测试类
//
//        Student stu1 = new Student();
//        stu1.setName("张三1");
//        stu1.setAge(20);
//        stu1.setClassID(1);
//        stu1.setHeight(150);
//        stu1.setGender("女");
//        stu1.setStuid(12);
//        if(studentDAO.update(stu1)){
//            System.out.println("修改学生成功！");
//        }else {
//            System.out.println("修改学生失败！");
//        }
//
//        //删除 -- 测试类
//        studentDAO s = new studentDAO();
//        //查询一个学生返回
//        Student stu2 = s.query(1);
//        System.out.println(stu2.getName()+stu2.getGender());
//
//    }
}
