package me.bingyue.daily.concurency;

/**
 * 线程调度 优先级
 * @author Daniel
 *
 */
public class ThreadDispatch {
	
	/**
	 * 线程的优先级用1-10之间的整数表示，数值越大优先级越高，默认的优先级为5。
	 * 在一个线程中开启另外一个新线程，则新开线程称为该线程的子线程，子线程初始优先级与父线程相同。
	 * 优先级高的线程获取CPU资源的概率较大，优先级低的并非没机会执行。
	 */
	public static void main(String[] args) {
		ThreadDispatch td=new ThreadDispatch();
		//注意内部类的语法
		Thread thread1=td.new MyThread();
		Thread thread2=new Thread(td.new MyRunnable());
		
		//分别设置不同的优先级
		thread1.setPriority(10);
		thread2.setPriority(1);
		//Start the thread
		thread1.start();
		thread2.start();
	}

	/**
	 * （1）定义Thread类的子类，并覆盖该类的run()方法。 
	 * （2）创建Thread子类的实例，即创建线程对象。 
	 * （3）用线程对象的start()方法来启动该线程。
	 *
	 */
	 class MyThread extends Thread{
		 public void run() {
			 for(int i=1;i<=10;i++){
//				 try {
//					Thread.sleep(0);//重新分配Cpu,调整数字会看到结果变化很大
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				 System.out.println("Thread1 执行第"+i+"次");
					
				}
			}
	 }
	 
	 /**
	  * 
	  * 定义Runnable接口的实现类，并实现该接口的run()方法。 
	  *（2）创建Runnable实现类的实例，然后将该实例作为参数传入Thread类的构造方法来创建Thread对象。 
	  *（3）用线程对象的start()方法来启动该线程。 
	  *
	  */
	 class MyRunnable implements Runnable{

		@Override
		public void run() {
			for(int i=1;i<=10;i++){
//				try {
//					Thread.sleep(0);//模拟线程工作耗时
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				System.out.println("Thread2 执行第"+i+"次");
				
			}
		}
		 
	 }
}
