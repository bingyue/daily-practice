package me.bingyue.interview;

/**
 * 给定数组array，每个数都为正数，且不重复，每个值代表一种面值的货币，
 * 每种面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，求换钱有多少种方法。
 * @Title: DPcoins 
 * @Description: TODO
 */
public class DPcoins {
	
	public static void main (String[] args){
		int[] arr={5,10,25,1,4};
		System.out.print(coins1(arr,100));
//		coins1(arr,1000);
	}
	
	public static int coins1(int[] array,int aim){
		if(array==null || array.length==0 || aim <=0){
			return 0;
		}
		/**
		 * 
		 */
		return process1(array,0,aim);
	}
	
	/**
	 * 如果用arr[index...N-1]这些面值的钱组成aim，返回总的方法数。
	 */
	public static int process1(int [] array,int index,int aim){
		int res=0;
		/**
		 * 明显，如果用唯一的一种钱币去组成钱数，方法肯定只有一种
		 */
		if(index==array.length ){
			res= aim==0?0:1;
		}else{
			//递归  暴力搜索
			for(int i=0;array[index]*i<=aim;i++){
				/**
				 * 
				 */
				res=process1(array,index+1,aim-array[index])+res;
			}
		}
		return res;
	}
}
