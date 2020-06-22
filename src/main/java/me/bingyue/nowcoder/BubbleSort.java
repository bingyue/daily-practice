package me.bingyue.nowcoder;

/**
 * 对于一个int数组，请编写一个冒泡排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。 
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 * @Title: BubbleSort 
 * @Description: TODO
 */
public class BubbleSort {
	
	public static void main(String[] args){
		int[] A={1,2,3,5,2,3};
		int n=6;
		BubbleSort tt=new BubbleSort();
		tt.bubbleSortDesc(A, n);
		for(int i=0;i<n;i++){
			System.out.print(A[i]);			
		}
	}

	public int[] bubbleSort(int[] A, int n) {
		if(n<=1){
			return A;
		}
        for(int i=n-1;i>=0;i--){//外层
        	 for(int j=0;j<i;j++){//内层
        		 if(A[j]>A[j+1]){
        			 swap(A,j,j+1);
        		 }
        	 } }
        
        return A;
    }
	
	/**
	 * 从大到小排序，从后到前开始冒泡
	 */
	public int[] bubbleSortDesc(int[] A, int n) {
		if(n<=1){
			return A;
		}
        for(int i=0;i<n;i++){//外层
        	
        	 for(int j=n-1;j>i;j--){//内层
        		 if(A[j]>A[j-1]){
        			 swap(A,j,j-1);
        		 }
        	 } }
        
        return A;
    }
	
	private void swap(int[] A, int index1,int index2){
		 int temp=A[index2];
		 A[index2]=A[index1];
		 A[index1]=temp;
	}
}
