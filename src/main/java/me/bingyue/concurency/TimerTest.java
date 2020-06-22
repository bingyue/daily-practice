package me.bingyue.concurency;

import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TimerTest
 */
public class TimerTest {  
    //被执行的任务必须继承TimerTask，并且实现run方法
    static class MyTimerTask1 extends TimerTask {  
        public void run() {  
            System.out.println("执行当前线程"+Thread.currentThread().getName());  
        }  
    }     
    /**
     * Timer线程不会捕获异常，所以TimerTask抛出的未检查的异常会终止timer线程。
     * 如果Timer线程中存在多个计划任务，其中一个计划任务抛出未检查的异常，则会引起整个Timer线程结束，从而导致其他计划任务无法得到继续执行。　　
     * Timer线程时基于绝对时间，因此计划任务对系统的时间的改变是敏感的。
     * Timer是单线程，如果某个任务很耗时，可能会影响其他计划任务的执行。
     * @param args
     * @throws ParseException
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws ParseException, InterruptedException {  
        Timer timer = new Timer();  
        /**
         * scheduleAtFixedRate方式
         * 设定两秒后执行任务
         */
        timer.scheduleAtFixedRate(new MyTimerTask1(), 2000,1000);
        /**
         * schedule添加Date参数
         * 设定任务在执行时间执行
         */
//        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
//        Date time = dateFormatter.parse("2016/03/28 14:40:00");  
//        timer.schedule(new MyTimerTask1(), time);
        //启动MyTimerTask1线程后，主线程休眠五秒钟，给MyTimerTask1五秒的执行时间
        Thread.sleep(5000);
        //终止Timer线程
        timer.cancel();
        }  
}
