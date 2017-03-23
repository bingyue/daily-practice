package me.bingyue.practice.programpearls;

/**
 * 字符串反转和旋转
 * 这两个基本的操作可以解决很多和字符串位置调整有关的问题
 * @Title: ReverseString 
 * @Description: TODO
 */
public class ReverseString {

	public static void main(String[] args){
		char[] chr={'a','b','c','d','e','f','g'};
//		reverse(chr,3,7);
		rotation(chr,3);
		System.out.println(chr);
	}
	
	/**
	 * 反转
	 * 在由char[]转为Sting注意不要使用toSting方法
	 */
	public static void reverse(char[] chr){
		int n=chr.length-1;
		//使用头尾两个指针从两边向中间扫，并且不断交换两个指针的内容
		for(int i=0;i<chr.length/2;i++){
			swap(chr,i,n--);
		}
	}
	/**
	 * 用于反转字符数组中index1~index2位置的这一段
	 * 左闭右开区间,index1<=下标<index2
	 */
	public static void reverse(char[] chr,int index1,int index2){
		if(index2-index1 < 2) 
			return; 
		int j=index2-1;//右侧下标
		for(int i=index1;i<(index2+index1)/2;i++){
			swap(chr,i,j--);
		}
	}
	
	/**
	 * 旋转
	 * 使用三次反转，实现旋转
	 * 数组注意区间取值
	 * @param m 从位置m处进行旋转
	 */
	public static void rotation(char[] chr,int m){
		//第一次倒置0~m位置
		reverse(chr,0,m);
		//第二次倒置m~最后位置
		reverse(chr,m,chr.length);
		//最后整体倒置
		reverse(chr,0,chr.length);
	}
	
	private static void swap(char[] arr,int index1,int index2){
		char temp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;
	}
	
}
