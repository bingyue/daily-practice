package me.bingyue.practice.concurency;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * 读写线程使用exchanger交换数据
 * @author bingyue
 *
 */
public class ExchangerDemo {

	public static void main(String[] args) {  
        Exchanger<List<String>> exchanger = new Exchanger<List<String>>();  
    }  
	
	
	class Producer implements Runnable {  
		
		private Exchanger<List<String>> exchanger;  
	    List<String> bufferList = new LinkedList<String>();  
	   
	    public Producer(Exchanger<List<String>> exchanger) {  
	        this.exchanger = exchanger;  
	    }

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}  
	}
	
	class Consumer implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}  
}
	
}  
