package test;

import day01.DemoBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test 测试
 * Case 案例
 */
public class TestCase {

    ClassPathXmlApplicationContext ctx;

    @Before //在测试案例之前执行的方法
    public void init(){
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @After  //在测试案例之后执行的方法
    public void desc(){
        ctx.close();
    }

    @Test
    public void testDemoBean(){
        DemoBean d = ctx.getBean("demo", DemoBean.class);
        System.out.println(d);
    }

    @Test
    public void testDemoBeanBieMing(){
        DemoBean d = ctx.getBean("bean1", DemoBean.class);
        System.out.println(d);
    }

    @Test
    public void testDanLi(){
        DemoBean d1 = ctx.getBean("demo1", DemoBean.class);
        DemoBean d2 = ctx.getBean("demo1", DemoBean.class);
        DemoBean d3 = ctx.getBean("demo1", DemoBean.class);
        System.out.println(d1 == d2); //false
        System.out.println(d2 == d3); //false
        System.out.println(d1 == d3); //false
    }
}
