package cn.tedu.mybatis;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    Integer addnew(User user);

    Integer deleteById(Integer id);

    Integer deleteByIds(Integer[] ids);

    Integer countAll();

    /*
    如果某个方法必须要使用多个参数，可以在每一个参数之前添加`@Param`注解，并在注解中
    定义参数的名称,在配置XML中的映射时，使用的#{}占位符中的也是注解中配置的名称
     */
    Integer updateEmailById(
            @Param("id") Integer id,
            @Param("email") String email);

    Integer updatePassword(String password);

    User findById(Integer id);

    List<User> findAll();

    List<User> find(
            @Param("where") String where,
            @Param("orderBy") String orderBy,
            @Param("offset") Integer offset,
            @Param("count") Integer count
    );

    UserVO findVOById(Integer id);

}
