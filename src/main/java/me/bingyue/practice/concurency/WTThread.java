package me.bingyue.practice.concurency;

public class WTThread extends Thread{
	public WTThread(String name) {
        super(name);
    }

    public void run() {
    	//同步锁
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()+" call notify()");
            /**
             * 这个线程执行的过程中会去唤醒当前对象的wait线程
             */
            notify();
        }
    }
}