package me.bingyue.concurency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用阻塞队列实现生产者-消费者模型
 * 阻塞队列只允许元素以FIFO的方式来访问
 * @author Daniel
 *
 */
public class ProducerCustomerPattern {
	
	public static void  main(String[] args) {

		//生产者和消费者共享的存储区域
		BlockingQueue<Integer> blockQueue=new LinkedBlockingQueue();
		
		/**
		 * 此处外部类访问静态方法调用内部类，必须先创建外部类实例。
		 * 如果你不需要内部类对象与其外围类对象之间有联系，那你可以将内部类声明为static。这通常称为静态嵌套类（Static Nested Classes）。
		 * 想要理解static应用于内部类时的含义，你就必须记住，普通的内部类对象隐含地保存了一个引用，指向创建它的外围类对象。
		 * 然而，当内部类是static的时，就不是这样了。嵌套类意味着：　　
		 * 1. 要创建嵌套类的对象，并不需要其外围类的对象。　
		 * 2. 不能从嵌套类的对象中访问非静态的外围类对象。
		 */
		ProducerCustomerPattern ps=new ProducerCustomerPattern();
		//注意创建内部类的方式
		Thread pro=new Thread(ps.new Producer(blockQueue));
		Thread cus=new Thread(ps.new Customer(blockQueue));
		
		pro.start();
		cus.start();
	}
	
	class Producer implements Runnable{
		
		private final BlockingQueue<Integer> queue;
		
		public Producer(BlockingQueue<Integer> queue){
			this.queue=queue;
		}

		@Override
		public void run() {
			for(int i=0;i<=10;i++){
				try {
					System.out.println("Produced:"+i);
					queue.put(i);
				} catch (InterruptedException e) {
					//对于阻塞的插入和移除方法  put和take都抛出 InterruptedException
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 通过实现Runnable接口线程创建
	 * (1).定义一个类实现Runnable接口，重写接口中的run()方法。在run()方法中加入具体的任务代码或处理逻辑。
	 * (2).创建Runnable接口实现类的对象。
	 * (3).创建一个Thread类的对象，需要封装前面Runnable接口实现类的对象。（接口可以实现多继承）
	 * (4).调用Thread对象的start()方法，启动线程
	 * 
	 * 通过继承Thread类创建线程
	 * (1).首先定义一个类去继承Thread父类，重写父类中的run()方法。在run()方法中加入具体的任务代码或处理逻辑。
	 * (2).直接创建一个ThreadDemo2类的对象，也可以利用多态性，变量声明为父类的类型。
	 * (3).调用start方法，线程t启动，隐含的调用run()方法。
	 */
	class Customer implements Runnable{

		private final BlockingQueue<Integer> queue;
		
		public Customer(BlockingQueue<Integer> queue){
			this.queue=queue;
		}
		
		@Override
		public void run() {
			while(true){
				try {
					System.out.println("Customed:"+queue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
