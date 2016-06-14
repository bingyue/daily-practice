package me.bingyue.daily.jvm;

import java.util.Date;

/**
 * 基本类型和引用类型的初始化不同
 * @author Bingyue
 *
 */
public class JVMTest {

	public void varRefValue(){
		int a;
		a=10;//正确，因为声明a时就分配了空间  
		Date date;
		//执行实例化，开辟数据空间存放Date对象，然后把空间的首地址传给today变量  
		date=new Date();
		//The local variable date may not have been initialized
		//也就是说对象的数据空间没有分配
		date.getDate();
	}
}
