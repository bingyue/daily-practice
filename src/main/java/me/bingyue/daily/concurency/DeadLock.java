package me.bingyue.daily.concurency;

/**
 * 死锁范例
 * 类的静态变量是各个实例共享的，只分配一次，因此对这两个变量的同步可能会导致死锁
 * 两个线程在分别占有obj1和obj2后，一直等待obj2和obj1的锁释放，进入死锁状态不能继续执行
 * @author Bingyue
 *
 */
public class DeadLock implements Runnable{
	
	int flag;
	/**
	 * 类的静态变量是各个实例共享的，只分配一次，因此对这两个变量的同步可能会导致死锁
	 */
	private static Object obj1 = new Object();
	private static Object obj2 = new Object();  
	DeadLock(int flag){
		this.flag=flag;
	}

	public static void main(String[] args){
		DeadLock thread1=new DeadLock(1);
		DeadLock thread2=new DeadLock(2);
		
		new Thread(thread1).start();  
        new Thread(thread2).start(); 
		
	}	 
	
		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			/**
			 * 线程1的操作
			 */
			if(flag==1){
				//线程1占有o1,同时请求o2的锁
	            synchronized (obj1) {  
	                try {
	                	System.out.println(name+"占有obj1的同步锁");  
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}  
	                synchronized (obj2) {  
	                    System.out.println(name+"继续执行得到obj2的同步锁");  
	                }   }  }
			/**
			 * 线程2的操作
			 */
			if(flag==2){
				//线程2占有o2,同时请求o1的锁
	            synchronized (obj2) {  
	                try {
	                	System.out.println(name+"占有obj2的同步锁");  
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}  
	                synchronized (obj1) {  
	                    System.out.println(name+"继续执行得到obj1的同步锁");  
	                }   }  }
		}
}
