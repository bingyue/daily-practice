package me.bingyue.daily.concurency;
/**
 * 配合使用wait和notify
 */
public class UseWaitNotify {

	public static void main(String[] args) throws InterruptedException{
		WTThread t1=new WTThread("t1");
		//同步锁
		 synchronized(t1) {
			//启动线程t1
            System.out.println(Thread.currentThread().getName()+" start t1");
            t1.start();
            
           /**
            * 主线程进入等待状态
            * 同时wait()释放主线程持有的同步锁
            */
            System.out.println(Thread.currentThread().getName()+" wait()");
            t1.wait();
            /**
             * 主线程等待后，释放了锁，t1线程就可以执行了
             * 于是会操作 下面的执行体
             * System.out.println(Thread.currentThread().getName()+" call notify()");
             * notify();
             */
            /**
             * t1执行完毕后，唤醒主线程，主线程持有锁，继续执行
             * 打印查看目前正在执行的线程
             */
            System.out.println(Thread.currentThread().getName()+" continue");
		 }
	}
}
