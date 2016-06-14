package me.bingyue.daily.algorithm;

public class FibonacciSearch {

	private static int MAXSIZE=20;
	
	/**
	 * 非递归方式构造一个斐波那契数组
	 */
	public static int[] fibonacci(){
		int[] fib=new int[MAXSIZE];
		fib[0]=0;
		fib[1]=1;
		for(int i=2;i<MAXSIZE;i++){
			fib[i]=fib[i-1]+fib[i-2];
		}
		return fib;
	}
	
	/**
	 * @Title: fibonacciSearch 
	 * @param arr 要查找的数组
	 * @param n 数组长度
	 * @param des 关键字
	 */
	public static int fibonacciSearch(int[] arr,int n,int des){
		int left=0;
		int right=n-1;
		int[] fib=fibonacci();
		
		int k=0;
		while(n>fib[k]-1){//找到n位于斐波那契数列的位置
			k++;
		}
		
		return -1;
	}
}
