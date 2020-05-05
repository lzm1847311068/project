package di;

import java.io.Serializable;

public class Worker implements Serializable {

    private String name = "光头强";
    private double salary;//薪水
    private Tools tools;

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setTools(Tools tools) {
        System.out.println("bean属性注入了...");
        this.tools = tools;
    }

    public void work(){
        System.out.println(name+"使用"+tools+"在砍树！"+"薪资"+salary);
    }
}
