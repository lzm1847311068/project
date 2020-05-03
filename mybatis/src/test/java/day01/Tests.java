package day01;

import cn.tedu.mybatis.User;
import cn.tedu.mybatis.UserMapper;
import cn.tedu.mybatis.UserVO;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Tests {

    ClassPathXmlApplicationContext ctx;
    UserMapper userMapper;

    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext("mybatis.xml");
        //接口没有实现类，mybatis框架动态生成了代理对象，自动实现了此接口，才可以getBean
        userMapper = ctx.getBean("userMapper",UserMapper.class);
    }

    @After
    public void desc(){
        ctx.close();
    }

    @Test
    public void testDataBase() throws SQLException {
        BasicDataSource bd = ctx.getBean("dataSource", BasicDataSource.class);
        Connection conn = bd.getConnection();
        System.out.println(conn);
    }

    @Test
    public void addnew(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("112233");
        Integer rows = userMapper.addnew(user);
        System.out.println("rows="+rows);
    }

    @Test
    public void deleteByID(){
        Integer rows = userMapper.deleteById(14);
        System.out.println("rows="+rows);
    }

    @Test
    public void countAll() {
        Integer count = userMapper.countAll();
        System.out.println("count=" + count);
    }

    @Test
    public void updateEmailById() {
        Integer id = 5;
        String email = "alex@163.com";
        Integer rows = userMapper.updateEmailById(id, email);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updatePassword() {
        String password = "1234567";
        Integer rows = userMapper.updatePassword(password);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findById() {
        Integer id = 10;
        User result = userMapper.findById(id);
        System.out.println(result);
    }

    @Test
    public void findAll() {
        List<User> list = userMapper.findAll();
        System.out.println("count=" + list.size());
        for (User item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void deleteByIds(){
        Integer[] ids = {6,100};
        Integer rows = userMapper.deleteByIds(ids);
        System.out.println("rows="+rows);
    }

    @Test
    public void find() {
        String where = null;
        String orderBy = "age DESC";
        Integer offset = 0;
        Integer count = 4;
        List<User> list = userMapper.find(where, orderBy, offset, count);
        System.out.println("count=" + list.size());
        for (User item : list) {
            System.out.println(item);
        }
    }
    
    @Test
    public void findVOById(){
        Integer integer = 14;
        UserVO vo = userMapper.findVOById(integer);
        System.out.println(vo);
    }
}
