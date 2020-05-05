package test;

import day02.DemoBean;
import day02.ExampleBean;
import day02.LogWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test 测试
 * Case 案例
 */
public class day02TestCase {

    ClassPathXmlApplicationContext ctx;

    @Before //在测试案例之前执行的方法
    public void init(){
        ctx = new ClassPathXmlApplicationContext("day02applicationContext.xml");
    }

    @After  //在测试案例之后执行的方法
    public void desc(){
        ctx.close();
    }

    @Test
    public void testLogWriter(){
        /*
        测试对象生命周期管理方法
         */
        LogWriter logger = ctx.getBean("logger", LogWriter.class);
        logger.print("hello world");
        logger.print("hello");
        System.out.println("写日志完成");
    }

    @Test
    public void testExBean(){
        /*
        非单例对象不能执行其对象销毁方法
         */
        ExampleBean e = ctx.getBean("exBean", ExampleBean.class);
        e.work();
    }

    @Test
    public void testDemoBean(){
        /*
        测试单例对象懒惰初始化
        1.对于一定使用的单例对象，采用容器启动立即初始化方式，使用
		    性能更好，更加合理
		2.对于使用机会很少，几乎不使用的单例对象，建议采用懒惰方式
		    初始化，可以节省资源耗用，提高软件性能，第一次使用性能稍差
         */
        DemoBean d1 = ctx.getBean("demoBean", DemoBean.class);
        DemoBean d2 = ctx.getBean("demoBean", DemoBean.class);
        //以上两个对象，只会创建一次（构造方法只会输出一次），第二个对象会复用第一个对象（单例）
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1 == d2);
    }


}
