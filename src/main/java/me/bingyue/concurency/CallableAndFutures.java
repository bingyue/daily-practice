package me.bingyue.concurency;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 执行多个带返回值的任务,并取得多个返回值
 * @author Daniel
 *
 */
public class CallableAndFutures {

	public static void main(String[] args) {
		/**
		 * Executors的ThreadFactory可以建立四种线程池：
		 * newCachedThreadPool()——缓存型池子，先查看池中有没有以前建立的线程，如果有，就 reuse.如果没有，就建一个新的线程加入池中。
		 * newFixedThreadPool(int)——newFixedThreadPool与cacheThreadPool差不多，也是能reuse就用，但不能随时建新的线程
		 * 其独特之处:任意时间点，最多只能有固定数目的活动线程存在，此时如果有新的线程要建立，只能放在另外的队列中等待，直到当前的线程中某个线程终止直接被移出池子
		 * newScheduledThreadPool(int)——调度型线程池。这个池子里的线程可以按schedule依次delay执行，或周期执行。
		 * newSingleThreadExecutor()——单例线程，任意时间池中只能有一个线程，
		 * 用的是和cache池和fixed池相同的底层池，但线程数目是1-1,0秒IDLE（无IDLE）
		 */
		ExecutorService threadPool=Executors.newCachedThreadPool();
		
		/**
		 * ExecutorCompletionService是CompletionService的实现，
		 * 这个接口有submit(),take(),poll()方法，将生产新的异步任务与使用已完成任务的结果分离开来的服务。
		 * 生产者 submit 执行的任务。使用者 take 已完成的任务，并按照完成这些任务的顺序处理它们的结果。
		 * 例如，CompletionService 可以用来管理异步 IO ，执行读操作的任务作为程序或系统的一部分提交，
		 * 然后，当完成读操作时，会在程序的不同部分执行其他操作，执行操作的顺序可能与所请求的顺序不同。 
		 */
		CompletionService cs=new ExecutorCompletionService<Integer>(threadPool);
		for(int i=0;i<10;i++){
			final int taskId=i;
			cs.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					return taskId;
				}
			});
		}
		
		
		for(int i=0;i<10;i++){
			try {
				/**
				 * 使用者 take 已完成的任务,同时新的任务继续执行
				 * 注意take()和poll方法的区别,都是获取并移除表示下一个已完成任务的 Future,
				 * 但是take()如果目前不存在这样的任务，则等待,poll则返回null。
				 */
				System.out.println(cs.take().get());//不能直接使用poll()然后get，可能nullpointer异常
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		
			}
	
}
