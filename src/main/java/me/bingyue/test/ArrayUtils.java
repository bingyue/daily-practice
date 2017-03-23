package me.bingyue.test;

/**
 * 数组工具类
 * @Title: ArrayUtils 
 * @Description: TODO
 */
public class ArrayUtils {

	public static void print(int[] array){
		int size=array.length;
		for(int i=0;i<size;i++){
			System.out.println(array[i]);
			if(i!=--size)
				System.out.println(",");
		}
	}
	
	public static void exchangeElements(int[] array,int index1,int index2){
		int temp=array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
}
