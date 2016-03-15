package bingyue.nowcoder.binarysearch;

/**
 * 数组局部最小值问题
 * 定义局部最小的概念，arr长度为1时，arr[0]是局部最小。
 * arr的长度为N(N>1)时，先考察数组两端的位置，如果arr[0]<arr[1]，或者说arr[N-1]<arr[N-2]，
 * 那么arr[0]和arr[N-1]就都是局部最小值
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。 
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 *
 */
public class Solution {
	
	/**
	 * 参考
	 */
	public int getLessIndexABC(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        //这里取的值把端点去掉了
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

	/**
	 * 注意区别递归和非递归，非递归就是使用while语句了
	 */
	public static int getLessIndex(int[] arr) {
		if(arr==null || arr.length==0){
			return -1;
		}
		
		if(arr.length==1){
			return 0;
		}
		/**
		 * 首先考察两端两头的位置,注意这个不能放在递归的过程中，
		 * 中间截取的部分并不是整个数组的两头
		 */
		if(arr[0]<arr[1]){//和上面的情况返回相同可以合并
			return 0;
	    }
	    if(arr[arr.length-2]>arr[arr.length-1]){
			return arr.length-1;
		}		
		return binarySolve(arr,0,arr.length-1);
    }
	
	//定义二分查找过程
	private static int binarySolve(int[] param,int left,int right){
		if(right-left>0){
			int mid=left+(right-left)/2;
			if(param[mid]<param[mid+1] && param[mid]<param[mid-1]){//101,100,102
				return mid;
			}else if(param[mid+1]<param[mid]){//101,100,99
				/**
				 * 注意这里一侧查找失败，没有去查找另一侧
				 */
				return binarySolve(param,left,mid);
			}else{//99,100,101
				return binarySolve(param,mid,right);
			}
		}else{
			return -1;
		}
	}
	
	public static void main(String[] args){
//		int[] arr1={};
//		int[] arr2={3};
		int[] arr3={98,34,56,45,90,88,199,189,78,48,32,12,10};
//		System.out.println(getLessIndex(arr1));
//		System.out.println(getLessIndex(arr2));
		System.out.println(getLessIndex(arr3));
	}
}
