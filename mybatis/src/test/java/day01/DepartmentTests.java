package day01;

import cn.tedu.mybatis.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DepartmentTests {

    ClassPathXmlApplicationContext ctx;
    DepartmentMapper mapper;

    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext("mybatis.xml");
        //接口没有实现类，mybatis框架动态生成了代理对象，自动实现了此接口，才可以getBean
        mapper = ctx.getBean("departmentMapper",DepartmentMapper.class);

    }

    @After
    public void desc(){
        ctx.close();
    }

    @Test
    public void findById(){
        Integer id = 3;
        DepartmentVO v = mapper.findById(id);
        System.out.println(v);
    }
}
