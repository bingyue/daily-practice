package me.bingyue.daily.jvm;

/**
 * 静态代码块严格按顺序加载和执行
 * @author Bingyue
 */
public class StaticArea {

	private static int a; 
    private int b; 

    static { 
    	StaticArea.a = 1; 
        System.out.println(a); 
        StaticArea temp = new StaticArea(); 
        temp.f(); 
        temp.b = 1000; 
        System.out.println(temp.b); 
    } 

    static { 
    	StaticArea.a = 2; 
        System.out.println(a); 
    } 

    public static void main(String[] args) { 
    } 

    static { 
    	StaticArea.a = 3; 
        System.out.println(a); 
    } 

    public void f() { 
        System.out.println("执行实例中方法"); 
    } 
}
