package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo2 {

    public static void main(String[] args) throws Exception {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tedu_ums","root","root");
        //3、创建sql执行对象
        Statement statement = connection.createStatement();
        //4、创建sql语句
        String sql = "insert into lzm values (10,'lzm'),(11,'Tom')";
        //5、执行sql
        int rows = statement.executeUpdate(sql);
        System.out.println(rows);
        //6、关闭资源
        connection.close();
    }
}
