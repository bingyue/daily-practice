package me.bingyue.nowcoder;

/**
 * 对于一个int数组，请编写一个归并排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 * @Title: MergeSort 
 * 
 */
public class MergeSort {
	
	public static void main(String[] args){
		int[] arr={10,9,8,7,6,5,4,3};
		mergeSort(arr, arr.length);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");			
		}
	}

	/**
	 * 结合分治和归并即可实现归并排序
	 */
	public static int[] mergeSort(int[] A, int n) {
		// write code here
		if(A==null || A.length<2){
			return A;
		}
		divideAndConquer(A,0,n-1);
		return A;
    }
	
	/**
	 * 归并排序的"分治"操作
	 * 归并操作，只能对一个两部分分别有序的数组进行排序操作，
	 * 但是结合分治和递归的思想，就可以对任意无序数组进行排序
	 */
	public static void divideAndConquer(int[] arr, int l,int r) {
		/**
		 * 递归函数都需要一个明确的终止条件，否则会死循环，导致StackOverflowError
		 * 这里的递归什么时候停止？
		 * 当有序区间的长度为0的时候，即输入的数组中l和r相等
		 * 或者可以判断l<r的情况决定是否执行函数
		 */
		if(l==r){
			return;
		}
			/**
			 * 注意对区间的选择，如果传入的l和r是下标值，即0到数组长度n-1，
			 * 那么取m=(l+r)/2时，明显此时m位置的元素是包括在左路的
			 */
			int m=(l+r)/2;
			/**
			 * 左路递归的对l和m进行归并，
			 * 最后一轮是l=0,r(即m)=1，继续操作r(即m)=0，递归终止
			 */
			divideAndConquer(arr,l,m);
			/**
			 * 右路递归的对l和m进行归并，
			 */
			divideAndConquer(arr,m+1,r);
			/**
			 * 这个m的取值可以想象一下，当有序区间长度为1，
			 * 即l=0，m=0，r=1时，明显m即(l+r)/2，不需要再加减
			 */
			merge(arr,l,m,r);//进行merge操作的递归栈最深层此时是merge(arr,0,0,1)
    }
	
	/**
	 * 归并排序的"归并"操作
	 * 归并特别容易出错，特别是丢失比较数据，不要漏了数组末位的元素
	 * 这个视频讲的不错:
	 * http://www.tudou.com/listplay/goytvXDql0w/hFFCJz8mBDM.html
	 */
	public static void merge(int[] arr, int left, int mid, int right) {
		//临时数组
        int[] help = new int[right - left + 1];
        int l = left;//0
        int r = mid + 1;//1
        int index = 0;//临时数组的下标指针
        while (l <= mid && r <= right) {//确保合并操作不越界
        	/**
        	 * 比较递归深层arr数组的两个元素，
        	 * 把小的那个放在临时数组中
        	 * 然后向上，最深层肯定执行一次就退出
        	 */
            if (arr[l] <= arr[r]) {
            	 help[index] = arr[l];
                 index++;
                 l++;
            } else {
                help[index] = arr[r];
                index++;
                r++;
            }
        }
        
       //如果左侧比较完了还有剩余，肯定左侧剩下的都大，全部赋值
        while (l <= mid) {
            help[index++] = arr[l++];
        }
        //如果右侧比较完了还剩余，剩下的肯定都大，全部赋值到临时数组
        while (r <= right) {
            help[index++] = arr[r++];
        }
        //最后用整个临时数组的元素替换待排序数组中这一次归并的区间
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }
	

}
