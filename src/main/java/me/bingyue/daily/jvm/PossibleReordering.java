package me.bingyue.daily.jvm;

/**
 * 可能发生重排序的场景
 * @Title: PossibleReordering 
 * @Description: TODO
 */
public class PossibleReordering {
	
	static class ReorderCase{
		static int x = 0, y = 0;
		static int a = 0, b = 0;

		public static void work() throws InterruptedException {
			 Thread one = new Thread(new Runnable() {
			        public void run() {
			            a = 1;
			            x = b;
			        }
			    });

			Thread other = new Thread(new Runnable() {
			        public void run() {
			            b = 1;
			            y = a;
			        }
			 });
			
			 /**
			  * java.lang.IllegalThreadStateException
			  * 同一个Thread不能重复调用start
			  */
			 one.start();other.start();
			 one.join();other.join();
			 System.out.println("(" + x + "," + y + ")");
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		 for(int i=0;i<1000000;i++){
			 System.out.print("第"+i+"次执行:");
			 ReorderCase temp=new ReorderCase();  
			 temp.work();
		   }
	}
}
