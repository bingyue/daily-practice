package me.bingyue.jvm;

import java.util.Vector;
/**
 * 内存泄露
 * @author Bingyue
 */
public class MemoryLeak {

	public static void main(String[] args){
		Vector v=new Vector(10);
		 for (int i=1;i<100; i++){
			 Object o=new Object();
			 v.add(o);
			 /**
			  * 此时，所有的Object对象都没有被释放，因为变量v引用这些对象
			  */
			 o=null;
			 }
	}
}
