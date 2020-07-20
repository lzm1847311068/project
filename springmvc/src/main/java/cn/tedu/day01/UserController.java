package cn.tedu.day01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @RequestMapping("login.do")
    public String login(){
        return "login";
    }

    @RequestMapping("reg.do")
    public String reg(String username,String password){
        return "reg";
    }

    @RequestMapping("handle_reg.do")
    public String hangdle_reg(String username,String password){
        System.out.println(username);
        System.out.println(password);
        return null;
    }


    @RequestMapping("handle_login.do")
    public String handle_login(String username, String password,
                               HttpSession session, ModelMap modelMap){
        String errorMessage = null;

        if("root".equals(username)){
            if("1234".equals(password)){
                session.setAttribute("username",username);
                //重定向
                return "redirect:index.do";
            }else {
                errorMessage = "密码错误";
                modelMap.addAttribute("errMsg",errorMessage);
                return "error";
            }
        }else {
            errorMessage = "用户名错误";
            modelMap.addAttribute("errMsg",errorMessage);
            return "error";
        }

    }
}
