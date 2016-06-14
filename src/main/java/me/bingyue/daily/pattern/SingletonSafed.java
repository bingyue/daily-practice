package me.bingyue.daily.pattern;


public class SingletonSafed {

	/**
	 * 要在于instance = new Singleton()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。
	 * 给 instance 分配内存
	 * 调用 Singleton 的构造函数来初始化成员变量
	 * 将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
	 * 禁止指令重排序优化
	 */
	
	//这里初始化为null不是必须的,在Java里所有引用类型的静态以及实例成员,没有显式地初始化的,都会被设为null
	private volatile static SingletonSafed uniqueInstance=null;
	
	private SingletonSafed(){
		//私有的构造方法，防止外部实例化
	}
	
	//注意设置为静态方法
	public static SingletonSafed getInstance(){
		
		if(uniqueInstance== null){
			/**
			 * 同步块加锁。程序员称其为双重检查锁，因为会有两次检查 instance == null，一次是在同步块外，一次是在同步块内。
			 * 为什么在同步块内还要再检验一次？因为可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例。
			 */
			synchronized(SingletonSafed.class){
				if(uniqueInstance== null){
					uniqueInstance= new SingletonSafed();					
				}
				
			}
		}
		    return uniqueInstance;
	}
}
