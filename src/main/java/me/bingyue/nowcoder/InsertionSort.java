package me.bingyue.nowcoder;

/**
 * 对于一个int数组，请编写一个插入排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 * @Title: InsertionSort 
 * @Description: TODO
 */
public class InsertionSort {

	public static void main(String[] args){
		int[] A={1,2,3,5,2,3};
		int n=6;
		InsertionSort tt=new InsertionSort();
		tt.insertionSort(A, n);
		for(int i=0;i<n;i++){
			System.out.print(A[i]+",");			
		}
	}
	
	/**
	 * 拿5,4,3,2,1,举例,共四趟排序
	 * 4,5,3,2,1
	 * 3,4,5,2,1
	 * 2,3,4,5,1
	 * 1,2,3,4,5
	 * 依次对从1~n-1位置的数和前面的比较，并插入到合适的位置，最终得到有序序列
	 */
	public int[] insertionSort(int[] A, int n) {
		if(A==null || A.length<2){
			return A;
		}
		for(int i=1;i<n;i++){//外层 从1开始，共n-1轮排序
			//这个中间变量可有可无
//			int temp=A[i];
			for(int j=0;j<i;j++){//内层 针对i下标的元素去和前面的元素依次比较并且插入（即交换）
				if(A[j]>A[i]){
					/**
					 * error:j从1开始，i从0开始，那么最开始的元素始终不能参加比较
					 */
					swap(A,i,j);
			}}
		}
       return  A;
    }
	
	private void swap(int[] A, int index1,int index2){
		 int temp=A[index2];
		 A[index2]=A[index1];
		 A[index1]=temp;
	}
}
