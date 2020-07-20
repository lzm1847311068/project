package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcDemo3 {
    public static void main(String[] args) throws Exception{
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tedu_ums","root","root");
        //3、创建sql执行对象
        Statement stat = con.createStatement();
        //4、创建sql语句
        String sql = "select * from lzm";
        //5、执行sql
        ResultSet resu = stat.executeQuery(sql);
        while (resu.next()){
            //数据库字段是什么类型就get什么类型
            int id = resu.getInt("id");
            String name = resu.getString(2);
            System.out.println(name+":"+id);
        }
        //6、关闭连接
        con.close();
    }
}
