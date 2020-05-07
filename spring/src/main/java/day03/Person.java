package day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

@Component
public class Person implements Serializable {

    private String name = "tom";
    @Autowired //自动注入对象属性
    private Chopper chopper;
    private Phone phone;

    @Resource //自动注入Bean属性
    public void setPhone(Phone phone) {
        System.out.println("注入"+phone);
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", chopper=" + chopper +
                ", phone=" + phone +
                '}';
    }
}
