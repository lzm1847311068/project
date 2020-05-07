package test;

import day02.DemoBean;
import day02.ExampleBean;
import day02.LogWriter;
import day03.Foo;
import day03.Person;
import day03.jdbcBean;
import di.Worker;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * Test 测试
 * Case 案例
 */
public class day03TestCase {

    ClassPathXmlApplicationContext ctx;

    @Before //在测试案例之前执行的方法
    public void init(){
        ctx = new ClassPathXmlApplicationContext("day03applicationContext.xml");
    }

    @After  //在测试案例之后执行的方法
    public void desc(){
        ctx.close();
    }

    @Test
    public void testJDBC(){
        /*
        测试读取jdbc.properties
         */
        Properties p = ctx.getBean("jdbc", Properties.class);
        System.out.println(p);
    }

    @Test
    public void testjdbcBean(){
        jdbcBean p = ctx.getBean("jdbcBean", jdbcBean.class);
        System.out.println(p);
    }

    @Test
    public void testDataSource() {
        /*
         * 测试Spring 管理的数据源连接池
         */
        DataSource ds = ctx.getBean("ds", DataSource.class);
        String sql = "select 'Hello World' as str";
        try(Connection conn = ds.getConnection()){
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getString("str"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDi(){
        Worker qiang = ctx.getBean("qiang", Worker.class);
        qiang.work();
    }

    @Test
    public void testFoo(){
        Foo f = ctx.getBean("foo", Foo.class);
        System.out.println(f);
    }

    @Test
    public void testPerson(){
        Person p = ctx.getBean("person", Person.class);
        System.out.println(p);
    }

}
