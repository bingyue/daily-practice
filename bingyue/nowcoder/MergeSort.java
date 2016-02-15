package bingyue.nowcoder;

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
		
		MergeSort tt=new MergeSort();
		//测试整个排序
		int[] A={1,2,3,5,2,3};
		tt.mergeSort(A, 6);
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]+",");			
		}
		//测试归并
//		int[] arr={2,8,9,10,4,5,6,7};
//		tt.merge(arr, 0, 4, 7);
//		for(int i=0;i<arr.length;i++){
//			System.out.print(arr[i]+",");			
//		}
	}

	/**
	 * 归并排序的"分治"操作
	 * 归并操作，只能对一个两部分分别有序的数组进行排序操作，
	 * 但是结合分治和递归的思想，就可以对任意无序数组进行排序
	 */
	public int[] mergeSort(int[] A, int n) {
		// write code here
		if(A==null || A.length<2){
			return A;
		}
		return null;
    }
	
	/**
	 * 归并排序的"分治"操作
	 * 归并操作，只能对一个两部分分别有序的数组进行排序操作，
	 * 但是结合分治和递归的思想，就可以对任意无序数组进行排序
	 */
	public void divideAndConquer(int[] arr, int l,int r) {
    }
	
	/**
	 * 归并排序的"归并"操作
	 * 归并特别容易出错，特别是丢失比较数据，不要漏了数组末位的元素
	 * 现在以数组{2,8,9,10,4,5,6,7,}为例
	 * 模拟一次二路归并的过程
	 * 这个视频讲的不错:
	 * http://www.tudou.com/listplay/goytvXDql0w/hFFCJz8mBDM.html
	 * @param arr 待归并的数组，这个数组可能只是整个数组中的一部分，所以需要下标来确定
	 * @param l 待归并数组最左边的下标
	 * @param m 待归并数组中间的下标
	 * @param r 待归并数组最右边的下标
	 */
	public void merge(int[] arr,int l,int m ,int r){
		//编程如做菜，准备好用到的变量等
		int left_size=m-l; //"左侧"临时数组大小
		int right_size=r-m+1; //"右侧"临时数组大小
		int[] left=new int[left_size]; //初始化
		int[] right=new int[right_size]; //初始化
		int i,j,k;
		
		/**
		 * 1.向左临时数组填充数据
		 * error:粗心操作两个临时数组的赋值
		 */
		for(i=l;i<m;i++)
			//这里用i-l表示left的下标,对应arr从l到m-,下面类似
			left[i-l]=arr[i];
		/**
		 * 2.向右侧临时数组赋值
		 * 注意这里容易出问题：j作为下标的区间应该是m~r,也就是说j<=r,或者j<r+1,
		 * 否则会丢失右侧最末位的数据，如果最后结果出现0,，一般是数组末位元素没处理好
		 * 这里为了记住这一点，将向左右两个临时数组赋值分成两步记忆
		 */
		for(j=m;j<r+1;j++)
			//这里用j-m表示right的下标,对应arr从m到r,下面类似
			right[j-m]=arr[j];

		/**
		 * 3.依次比较左右两个数组，并且合并填充到最开始的arr数组
		 * 此时i,j,k分别指向left的下标，right的下标，以及arr的下标
		 * 此时认为arr是空的,
		 * left{2,8,9,10}
		 * right{4,5,6,7}
		 * 这里用while循环最合适
		 */
		i=0;j=0;k=l;
		while(i<left_size && j<right_size){
			if(left[i]<right[j]){//左侧数组的较小，填入arr
				arr[k]=left[i];
				i++;
				k++;
			}else{
				arr[k]=right[j];//右侧数组的较小，将右侧填入arr
				j++;
				k++;
			}
		}
		
		/**
		 * 4.如果完成了左右两个数组的填充和对比，其中一个数组依然有余下的部分，
		 * 那么直接将其全部填充到arr数组中就可以
		 */
		while(i<left_size){//"左侧"数组有剩余
			arr[k]=left[i];
			i++;k++;
		}
		
		while(j<right_size){//"右侧"数组有剩余
			arr[k]=right[j];
			j++;k++;
		}
		
	}
	

}
