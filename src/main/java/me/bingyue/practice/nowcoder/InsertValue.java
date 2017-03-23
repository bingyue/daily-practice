package me.bingyue.practice.nowcoder;

/**
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 * 测试样例：
 * [1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 * @Title: InsertValue 
 * @Description: TODO
 */
public class InsertValue {
	
	public static void main(String[] args){
		int[] A={1,3,4,5,7};
		int[] nxt={1,2,3,4,0};
		ListNode result=insert(A,nxt,2);
		System.out.println(result);
	}

	/**
	 * 注意题目给定的链表变现形式，用两个数组，一个数组储存节点值，另一个数组保存对应节点值指向的下一个节点编号。
	 * （1）如果链表为空
	 * 将node的next指针指向自己，返回node即可。
	 * （2）如果链表不为空
	 * 令变量previous等于头结点，变量ncurrent等于头结点的下一个节点，两个指针同步移动下去，如果遇到p.value<=num，c.value>=num，
	 * 就把node插入其中，将node的prev指针指向当前的p，next指针指向当前的c即可。
	 * （3）如果p和c转一圈都没有发现应该插入的位置，其实此时node的值应该是比链表中所有的值都大，或者都小，应该插入头节点的前面。但是注意，因为需要保证有序，所以两种情况下，链表的头部是不一样的。
	 */
	public static ListNode insert(int[] A, int[] nxt, int val) {
		//链表为空的情况
		if(A==null ){
			ListNode node=new ListNode(val);
			node.next=node;
			return node;
		}
		//只有一个节点的情况
		if(A.length==1 ){
			ListNode node1=new ListNode(A[0]);
			ListNode node2=new ListNode(val);
			node1.next=node2;
			node2.next=node1;
			return A[0]<=val? node1:node2;
		}
		
		/**
		 * nxt数组要用起来，
		 * 注意，题目给定的保存节点编号的数组不一定是完全按照次序排列的，需要考虑到这种情况
		 * 调整的过程即把val添加到值数组中，并且调整编号数组，这种方法需要对数组扩容
		 * ！先不要急着构造链表！最后再构造环形链表，并且返回头部
		 */
		int[] AA=arrycopy(A);
		int[] nxtNxt=arrycopy(nxt);
		int size=A.length;//A.length=nxt.length
		AA[A.length]=val;
		
		for(int i=0;i<A.length;i++){
			if(A[i]<=val && A[nxt[i]]>=val){//链表最初有序，所以可以在当前位置插入
				nxtNxt[i]=A.length+1;//此时A[i]节点的下一个元素编号应该是刚刚添加的val的位置
				nxtNxt[A.length]=nxt[i];//此时val节点的下一个元素指向A[nxt[i]]的位置
				//直接构造返回即可
				return constructList(AA,nxtNxt);
			}
		}
		/**
		 * 上一步没成功，没有符合条件的节点，继续往下执行
		 */
		nxtNxt[nxt.length]=0;
		nxtNxt[nxt.length-1]=nxt.length;
		return constructList(AA,nxtNxt);
    }
	/**
	 * 数组扩容空间加1
	 */
	private  static int[] arrycopy(int[] bef) {  
        int[] aft = new int[bef.length + 1];  
        System.arraycopy(bef, 0, aft, 0, bef.length);  
        return aft;  
    }  
	
	/**
	 * 返回构造后的头结点
	 * 需要比较头和尾的节点大小
	 */
	private  static ListNode constructList(int[] AA, int[] nxtNxt){
		for(int i=0;i<AA.length;i++){
			ListNode previous=new ListNode(AA[i]);//从头节点开始遍历
			ListNode current=new ListNode(AA[nxtNxt[i]]);//用于保存previous节点的下一个节点,注意nxt数组保存previous节点的next节点值在数组中位置
			previous.next=current;
		}
		/**
		 * 比较val和头节点的值那个大
		 */
		if(AA[AA.length-1]<AA[0]){//应该返回以val为头节点的环形链表
			ListNode header=new ListNode(AA[AA.length-1]);
			return header;
		}else {//返回以原来的头节点，val作为链表末位
			ListNode header=new ListNode(AA[0]);
			return header;
		}
		
	}
}
