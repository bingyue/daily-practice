package me.bingyue.practice.nowcoder;

import java.util.LinkedList;

/**
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 * 给定两个链表的头指针headA和headB，请返回一个vector，
 * 元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 * 测试样例：
 * {1,2,3,4,5,6,7},{2,4,6,8,10}
 * 返回：[2.4.6]
 * @Title: Common 
 * @Description: TODO
 */
public class Common {
	
	   /**
	    * 是公共值，不是公共片段
	    * 1.最暴力肯定是嵌套循环，公共值加入结果集数组
	    * 2.注意是升序的，如何利用？ 
	    * 在嵌套循环时如果B在此位置的值大于A的此位置，直接break，从A的下一个位置开始
	    * 3.果然是考察代码，这就是高性能了，66666
	    */
	    public static int[] findCommonParts(ListNode headA, ListNode headB) {
	    	if(headA==null || headB==null){
	    		return null;
	    	}

	    	/**
	    	 * error!
	    	 * Java刷题就是坑，
	    	 * int[] result = new int[500]这种初始化会默认构造一个500个元素都是0的数组
	    	 */
	    	LinkedList<Integer> list=new LinkedList<>();//LinkedList的几个方法还要去看一下
	    	while(headA!=null && headB!=null){
	    	    if(headA.val<headB.val){
	    			headA=headA.next;
	    		}else if(headA.val>headB.val){
	    			headB=headB.next;
	    		}else{
	    			list.push(headA.val);
	    			headA=headA.next;
	    			headB=headB.next;
	    		}
	    	}
	    	int[] result = new int[list.size()];
	    	System.out.println(list.size());
	    	//LinkedList的某些性质导致有问题
	    	for(int i=0;i<list.size();i++){
	    		result[i]=list.pollLast();
	    	}
	    	return result;
	    }

	    public int[] findCommonPartsRef(ListNode headA, ListNode headB) {
		   LinkedList<Integer> list = new LinkedList<Integer>();
		   while (headA != null && headB != null) {
			  if (headA.val < headB.val) {
				headA = headA.next;
			  } else if (headA.val > headB.val) {
				headB = headB.next;
			  } else {
				list.add(headA.val);
				headA = headA.next;
				headB = headB.next;
			}
		}
		  int[] res = new int[list.size()];
		  int index = 0;
		  while (!list.isEmpty()) {
			res[index++] = list.pollFirst();
		  }
		  return res;
	}
	    
	  public static void main(String[] args){
		  ListNode HeadA=new ListNode(1);
		  ListNode Head1=new ListNode(2);
		  ListNode Head2=new ListNode(5);
		  HeadA.next=Head1;
		  Head1.next=Head2;
		  
		  ListNode HeadB=new ListNode(1);
		  ListNode Head3=new ListNode(3);
		  ListNode Head4=new ListNode(5);
		  ListNode Head5=new ListNode(7);
		  HeadB.next=Head3;
		  Head3.next=Head4;
		  Head4.next=Head5;
		  
		  int[] result=findCommonParts(HeadA,HeadB);
		  for(int i=0;i<result.length;i++){
			  System.out.println(result[i]);
	    	}
	  }
}
