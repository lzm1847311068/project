package cn.tedu.day01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping("index.do")
    public String index(HttpSession session, ModelMap map){
        String username = session.getAttribute("username").toString();
        //往前台传数据
        map.addAttribute("uname",username);
        return "index";
    }
}
