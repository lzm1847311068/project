package cn.lzm.springboot.mapper;

import cn.lzm.springboot.entity.User;

public interface UserMapper {

    Integer addnew(User user);

    User findByUsername(String username);
}
