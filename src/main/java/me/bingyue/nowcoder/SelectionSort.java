package me.bingyue.nowcoder;

/**
 * 对于一个int数组，请编写一个选择排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 * @Title: SelectionSort 
 */

public class SelectionSort {
	
	public static void main(String[] args){
		int[] A={1,2,3,5,2,3};
		int n=6;
		SelectionSort tt=new SelectionSort();
		tt.selectionSort(A, n);
		for(int i=0;i<n;i++){
			System.out.print(A[i]+",");			
		}
	}
	
	public int[] selectionSort(int[] A, int n) {
		if(A==null || A.length<2){
			return A;
		}
		/**
		 * 这个排序是直接选择吧
		 */
		for(int i=0;i<n-1;i++){
			int minIndex=i;
			for(int j=i+1;j<n;j++){
				if( A[j]<A[minIndex]){
					//循环完成的时候，minIndex下标处的元素就是这趟排序中最小的
					minIndex=j;
				}
			}
			/**
			 * 内层循环完成，minIndex有可能还是i，也可能不是i了,
			 * 先判断一下，再决定要不要交换到最左边
			 */
			
			if(i!=minIndex){
				swap(A,i,minIndex);				
			}
		}
		return A;
	}
	
	/**
	 * 这是写了个什么排序？666
	 * 这里的内层循环寻找最小值的过程，会发生多次交换，
	 * 比如5,4,3,2,1,会把数组顺序打乱，但是如果添加中间下标作为变量，就没有这个问题，
	 * 这个其实是一种不太明显的冒泡排序
	 */
	public int[] mySelectionSort(int[] A, int n) {
		if(A==null || A.length<2){
			return A;
		}
		/**
		 * error:注意边界条件,选择排序的外层只需要循环n-1次,
		 * 最后一个元素肯定是最大的，不需要比较，所以i<n-1即可
		 * 但如果j<n-1,漏掉了最后的A[n-1]
		 */
		for(int i=0;i<n-1;i++){//外层循环
			for(int j=i+1;j<n;j++){//内层循环
				 /**
				  * 选择是区间上选择一个最小的，即比较一遍
				  */
				if(A[j]<A[i]){//如果后面的比这个要小，交换，继续
					swap(A,i,j);
				}}
			}
		return A;
    }
	
	private void swap(int[] A, int index1,int index2){
		 int temp=A[index2];
		 A[index2]=A[index1];
		 A[index1]=temp;
	}
}
