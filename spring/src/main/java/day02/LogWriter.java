package day02;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * 日志写出功能类
 */
public class LogWriter implements Serializable {

    private PrintWriter out;

    //一定要先调用init方法，不然会出现空指针异常
    //对象生命周期的初始化方法
    public void init() throws IOException {
        System.out.println("初始化LogWriter");
        out = new PrintWriter("demo.log");
    }

    public void print(String log){
        out.println(log);
    }

    //对象生命周期的销毁方法
    public void close(){
        System.out.println("关闭LogWriter");
        out.close();
    }
}
