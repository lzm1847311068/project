package cn.lzm.springboot.controller;

import cn.lzm.springboot.entity.User;
import cn.lzm.springboot.mapper.UserMapper;
import cn.lzm.springboot.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping("reg")
    public JsonResult reg(User user){
        JsonResult json = new JsonResult();
        User result = mapper.findByUsername(user.getUsername());
        if(result != null){
            json.setStatus("error");
            return json;
        }
        mapper.addnew(user);
        json.setStatus("success");
        return json;
    }
}
