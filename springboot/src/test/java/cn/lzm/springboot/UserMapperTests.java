package cn.lzm.springboot;

import cn.lzm.springboot.entity.User;
import cn.lzm.springboot.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper mapper;

    @Test
    public void addnew() {
        User user = new User();
        user.setUsername("springboot100");
        user.setPassword("456456");
        Integer rows = mapper.addnew(user);
        System.err.println("rows=" + rows);
    }

    @Test
    public void findByUserName() {
        String username = "springboot";
        User user = mapper.findByUsername(username);
        System.err.println(user);
    }
}
