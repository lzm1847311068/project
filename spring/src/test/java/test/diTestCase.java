package test;

import day01.DemoBean;
import di.TestBean;
import di.Worker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Test 测试
 * Case 案例
 */
public class diTestCase {

    ClassPathXmlApplicationContext ctx;

    @Before //在测试案例之前执行的方法
    public void init(){
        ctx = new ClassPathXmlApplicationContext("diApplicationContext.xml");
    }

    @After  //在测试案例之后执行的方法
    public void desc(){
        ctx.close();
    }

    @Test
    public void testDi(){
        /*
        测试依赖注入的结果
         */
        Worker qiang = ctx.getBean("qiang", Worker.class);
        qiang.work();
    }

    @Test
    public void testBean(){
        /*
        测试集合和数组注入
         */
        TestBean b = ctx.getBean("testBean", TestBean.class);
        System.out.println(b);
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
}
