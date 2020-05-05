package day01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {

    public static void main(String[] args) {

        //1.初始化Spring容器
        /*
         * ClassPathXmlApplicationContext == Spring IOC容器
         * 在创建c对象（Spring IOC容器）时候，Spring会根据xml配置文件，创建xml文件中登记的对象
         */
        ClassPathXmlApplicationContext c =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        //2.获取Spring IOC创建的对象
        /*
         * 从spring容器对象中获取已经创建好的对象
         */
        DemoBean bean = (DemoBean)c.getBean("demo");
        //检查对象是否创建成功
        System.out.println(bean);
    }
}
