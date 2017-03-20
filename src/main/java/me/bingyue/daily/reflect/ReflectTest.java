package me.bingyue.daily.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args){
		
		try {
			testInvoke1();
			testInvoke2();
			testField();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testInvoke1() throws Exception{
		Person behavior=new Person();
		Class cls=behavior.getClass();
		Method method=cls.getDeclaredMethod("speak", String.class);
		method.invoke(behavior, "测试1-下午好!");	
	}
	
	public static void testInvoke2() throws Exception{
		 Class cls = Class.forName("me.bingyue.daily.reflect.Person");
		 Person bhv=(Person) cls.newInstance();	
		 bhv.speak("测试2-下午好！");
	}
	
	public static void testField() throws Exception{
		 Class cls = Class.forName("me.bingyue.daily.reflect.Person");
		 Field[] field = cls.getDeclaredFields();  
	     System.out.println("显示类的属性");  
	     for (Field f : field) {  
	         //getName()返回此 Field 对象表示的字段的名称  
	         //getType()返回一个 Class 对象，它标识了此 Field 对象所表示字段的声明类型。  
	         System.out.println(f.getName() + "        " + f.getType());  
	     }  
	}
	
	
}
