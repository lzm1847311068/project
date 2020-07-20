package jdbc;

import java.sql.*;

public class jdbcDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tedu_ums","root","root");
        System.out.println(conn);
        //3、创建sql执行对象
        Statement stat = conn.createStatement();
        //4、创建sql语句
        String sql = "create table lzm (id int,name varchar(10))";
        //5、执行sql语句
        stat.execute(sql);
        //6、关闭资源
        conn.close();
    }
}
