package me.bingyue.daily.algorithm;

public class BinarySearch {

	/**
	 * @Title: binSearch 
	 * @Description: TODO 
	 * @param arr 
	 * @param des
	 * @return 匹配成功的下标
	 */
	public static int binSearch(int[] arr,int des){
		
		if(arr==null || arr.length<1){
			return -1;
		}
		
		int left=0;
		int right=arr.length-1;//注意防止数组下标越界
		/**
		 * 这里的判断条件必须包含等于，
		 * 考虑{1,2,3}，查找1，如果不判断等于，就丢失了比较导致查找错误
		 */
		while(left<=right){
			int mid=left+(right-left)/2;
			if(des==arr[mid]){
				return mid;
			}else if(des<arr[mid]){//舍弃右侧
				/**
				 * 注意，此处的mid已经参与过比较了并失败了，
				 * 所以重新二分不要包含进来，下同
				 */
				right=mid-1;
			}else{//舍弃左侧
				left=mid+1;
			}
		}
		return -1;//查找失败 返回-1
	}
	
	/**
	 * @Title: bSearchRecursion 
	 * 递归参数有不同，left和right明显在每次递归时都是变的
	 */
	public static int binSearchRecursion(int[] arr,int left,int right,int des){
		
		if(arr==null || arr.length<1){
			return -1;
		}
		
		if(left<=right){
			int mid=left+(right-left)/2;
			if(des==arr[mid]){
				return mid;
			}else if(des<arr[mid]){//舍弃右侧
				return binSearchRecursion(arr,left,mid-1,des);
			}else{//舍弃左侧
				return binSearchRecursion(arr,mid+1,right,des);
			}
		}
		return -1;
			
	}
	
	public static void main(String[] args){
		int[] arr={1,2,3,4,5,7};
		int left=0;
		int right=arr.length-1;//注意防止数组下标越界
		System.out.println(binSearch(arr,7));
		System.out.println(binSearchRecursion(arr,left,right,1));
	}
}
