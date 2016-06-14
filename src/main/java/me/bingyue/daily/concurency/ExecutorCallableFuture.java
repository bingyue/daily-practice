package me.bingyue.daily.concurency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用Executor启动任务
 * 
 * @author Daniel
 *
 */
public class ExecutorCallableFuture {

	public static void main(String[] args) {
		//单例线程池
		ExecutorService threadPool=Executors.newSingleThreadExecutor();
		
		Future<Integer> future=threadPool.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
		});
		
		
		/**
		 * Thread.sleep(1)是一个静态方法，目的是使当前使用此sleep的线程休眠，
		 * 使用静态方法就如同使用内存中早已分配好的一块区域，和this.sleep(1)不同。
		 * Thread.sleep().会让“当前线程”休眠，当然如果是在主方法内休眠，效果就是“主线程”在主方法内休眠。
		 * Thread.sleep()作用是将线程挂起，Thread.sleep()需要捕捉异常
		 */
		try {
			Thread.sleep(500);
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
}
