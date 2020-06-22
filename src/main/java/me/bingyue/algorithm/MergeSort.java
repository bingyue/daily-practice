package me.bingyue.algorithm;

/**
 * 归并排序
 * @author Bingyue
 */
public class MergeSort {
	
	public static void main(String[] args){
		int[] arr=new int[]{8,7,6,5,4,3,2,1};
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");			
		}
		//想起引用传递和值传递的问题，数组是引用传递，不需要什么返回值
		sort(arr,arr.length);
		System.out.println("排序后");	
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");			
		}
	}
	
	public static void sort(int[] arr,int n){
		if(arr==null || n<2){
			return;//边界情况
		}
		divide(arr,0,n-1);
	}

	/**
	 * 
	 * @param arr 待排序数组
	 * @param left 待排序区间左侧下标
	 * @param right 待排序区间右侧下标
	 */
	public static void divide(int[] arr,int left,int right){
		
		if(left>=right){
			return;
		}
		int m=(left+right)/2;//从中间开始分成两个区间进行归并
		divide(arr,left,m);//一直递归划分直到区间长度为1
		divide(arr,m+1,right);
		//开始逐级往上进行归并操作
		binaryMerge(arr,left,m,right);//第一次进行merge操作的递归栈最深层此时是merge(arr,0,0,1)
	}
	
	/**
	 * 对数组arr[left...right]位置进行递归的归并排序
	 * @param arr
	 * @param left
	 * @param rigtht
	 * @param temp
	 */
	public static void binaryMerge(int[] arr,int left,int m,int right){
		/**
		 * 归并排序的时间复杂度为O(n),指的就是最大长度为n的临时数组
		 */
		int[] temp=new int[right-left+1];
		int l=left;//
		int r=m+1;//
		int index=0;//
		
		while(l<=m && r<=right){
			if(arr[l]<arr[r]){
				temp[index]=arr[l];
				index++;
				l++;
			}else{
				temp[index]=arr[r];
				index++;
				r++;
			}
		}
		
		/**
		 * 交换完了如果哪一侧数组还有剩余，则全部赋值
		 * 实际的一次归并下面的两个while循环只会执行一个
		 * warn!不要漏了等于的情况！否则会每两个元素丢失一个元素
		 */
		while(l<=m){
			temp[index]=arr[l];
			index++;
			l++;
		}
		
		while(r<=right){
			temp[index]=arr[r];
			index++;
			r++;
		}
		
		/**
		 * 用临时数组的部分排序的序列全部替换待排序数组中对应的部分
		 * 这里应该用temp.length，不能用arr.length
		 */
		for(int i=0;i<temp.length;i++){
			//注意是left，此时的l是已经变化了的
			arr[left+i]=temp[i];
		}
		
	}
	
}
