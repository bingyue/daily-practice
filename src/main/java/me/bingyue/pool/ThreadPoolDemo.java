package me.bingyue.pool;
//package me.bingyue.daily.threadpool;
//
//import java.util.concurrent.BlockingQueue;
//
///**
// * 自定义并实现线程池
// * 参考了ThreadPoolExecutor的实现
// * @author Bingyue
// */
//public class ThreadPoolDemo {
//	
////	public static final int  
//
//	//任务队列缓冲
//	private final BlockingQueue<Runnable> workQueue;
//	
//	/**
//	 * 空的构造函数
//	 */
//	
//	public ThreadPoolDemo(int capacity,int busy,BlockingQueue<Runnable> workQueue){
//		
//	}
//
//	
//	/**
//	 * 线程池实例对象
//	 */
//    private static ThreadPoolDemo instance = ThreadPoolDemo.getInstance();
//    
//    /**
//     * 维护一个单例的线程池实例
//     * @return
//     */
//    public static ThreadPoolDemo getInstance(){
//    	if(instance==null){
//    		     return new ThreadPoolDemo();
//    	}
//    	return instance;
//    }
//}
