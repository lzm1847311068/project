package cn.lzm.springboot.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//添加定时任务注解,这个注解就好像是开关一下，启动的时候一旦扫描到就标志有定时任务存在
@EnableScheduling
public class MyScheduledTask {

    /*
    秒（0~59） 例如0/5表示每5秒
    分（0~59）
    时（0~23）
    日（0~31）的某天，需计算
    月（0~11）
    周几（ 可填1-7 或 SUN/MON/TUE/WED/THU/FRI/SAT）
    年（可选）1970-2099
    *：表示匹配该域的任意值，假如在 分 域使用*, 即表示每分钟都会触发事件
    ?：只能用在 日 和 星期 两个域，它也匹配域的任意值，但是有种情况例外，如写法： 13 13 15 20 * ?, 其中最后一位只能用？，而不能使用*，如果使用*表示不管星期几都会触发
     */
    @Scheduled(cron = "59 24 22 * * ?")
    public void scheduledTask1(){
        System.out.println("定时任务1");
    }

    /*
    initialDelay：程序启动后多久开始执行，单位是毫秒，不同方法同样计时,只在程序启动时执行一次
    fixedRate：下次执行时间，任务开始运行的时候就计时
    fixedDelay：下次执行时间，fixedDelay等任务进行完了才开始计时（此方法进行完毕后开始计时）
     */
    @Scheduled(initialDelay = 1000*10,fixedDelay = 100000*5)
    public void scheduledTask2(){
        System.out.println("任务2执行");
    }

    @Scheduled(initialDelay = 1000*10,fixedDelay = 1000*8)
    public void scheduledTask3(){
        //System.currentTimeMillis(); 返回的是以毫秒为单位的当前时间
        System.out.println("任务3执行时间:"+System.currentTimeMillis()%10000);
        try {
            //毫秒
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务3结束时间:"+System.currentTimeMillis()%10000);
    }
}
