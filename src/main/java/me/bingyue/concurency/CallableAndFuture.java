package me.bingyue.concurency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 如何使用callable和future
 * @author Daniel
 *
 */
public class CallableAndFuture {

	public static void main(String[] args) {
		
		Callable<Integer> callable;
		callable = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// 添加回调函数的返回结果
				return new Random().nextInt(100);
			}
		};

		/**
		 * FutureTask实现了RunnableFuture接口，
		 * Java中类的继承只支持单继承，但Java接口可以多继承，
		 * RunnableFuture继承了Runnable, Future<V>两个父接口
		 * 注意：如果在两个父接口中分别定义了名称和参数都相同，而返回结果却不同的方法，会有编译时错误。
		 */
		FutureTask<Integer> future = new FutureTask(callable);
		/**
		 * 启动一个线程
		 * FutureTask继承了Runnable接口,可以被线程执行。
		 * 同时可以作为Future得到Callable的返回值。
		 */
		new Thread(future).start();
		 
		try {
			/**
			 * 假设有一个很耗时的返回值需要计算，并且这个返回值不是立刻需要的话，
			 * 那么就可以使用这个组合，
			 * 用另一个线程去计算返回值，而当前线程在使用这个返回值之前可以做其它的操作，
			 * 等到需要这个返回值时，再通过Future得到。
			 */
			
			Thread.sleep(5000);//可以执行其他的操作
			/**
			 * 这是回调模式的一种典型使用!
			 */
			System.out.println(future.get());//需要返回值时,再通过future得到
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	
}
