package me.bingyue.algorithm;

/**
 * 主要参考《数据结构与算法分析—Java语言实现》
 * @Title: BinarySearchTree 
 */
public class BinarySearchTree <T extends Comparable<? super T>>{

	//节点数据结构 静态内部类
	static class BinaryNode<T>{
		T data;
		BinaryNode<T> left;
		BinaryNode<T> right;
		public BinaryNode(){
			data=null;
		}
		public BinaryNode(T data) {
			this(data,null,null);
		}
		public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
	
	//私有的头结点
	private BinaryNode<T> root;
	
	//构造一棵空二叉树
	public BinarySearchTree(){
		root=null;
	}
	//二叉树判空
	public boolean isEmpty(){
		return root==null;
	}
	//清空二叉树
	public void clear(){
		root=null;
	}
	
	//检查某个元素是否存在
	public boolean contains(T t){
		return contains(t,root);
	}
	
	/**
	 * 从某个节点开始查找某个元素是否存在
	 * 在二叉查找树中查找x的过程如下：
	 * 1、若二叉树是空树，则查找失败。
	 * 2、若x等于根结点的数据，则查找成功，否则。
	 * 3、若x小于根结点的数据，则递归查找其左子树，否则。
	 * 4、递归查找其右子树。
	 */
	public boolean contains(T t,BinaryNode<T> node){
		if(node==null){
			return false;
		}
		/**
		 * 这就是为什么使用Comparable的泛型
		 * compareTo的对象也必须是实现了Comparable接口的泛型,
		 * 所以参数必须是BinaryNode<T> node格式
		 */
		int result=t.compareTo(node.data);
		if(result>0){//去右子树查找
			return contains(t,node.right);
		}else if(result<0){//去左子树查找
			return contains(t,node.left);
		}else{
			return false;			
		}
	}
	
	//插入元素
	public void insert(T t){
		root=insert(t,root);
	}
	
	/**
	 * 将节点插入到以某个节点为头的二叉树中
	 * 这个插入其实也是一个递归的过程
	 * 递归最深层的返回结果一个包含要插入的节点子树的头节点
	 */
	public BinaryNode insert(T t,BinaryNode<T> node){
		//如果是空树，直接构造一棵新的二叉树
		if(node==null){
			return new BinaryNode<T>(t);
		}
		
		int result=t.compareTo(node.data);
		
		if(result<0){
			node.left=insert(t,node.left);
		}else if(result>0){
			node.right=insert(t,node.right);
		}else{
			;//即要插入的元素和头节点值相等，直接返回即可
		}
		return node;
	}
	
	
	/**
	 * 删除元素
	 * 返回调整后的二叉树头结点
	 */
	public BinaryNode delete(T t){
		return delete(t,root);
		
	}
	
	/**
	 * 在以某个节点为头结点的树结构中删除元素
	 * 首先需要找到该关键字所在的节点p，然后具体的删除过程可以分为几种情况：
	 * p没有子女，直接删除p
	 * p有一个子女，直接删除p
	 * p有两个子女，删除p的后继q（q至多只有一个子女）
	 * 确定了要删除的节点q之后，就要修正q的父亲和子女的链接关系，
	 * 然后把q的值替换掉原先p的值，最后把q删除掉
	 */
	public BinaryNode delete(T t,BinaryNode<T> node){
		if(node==null){//节点为空还要啥自行车
			return node;
		}
		/**
		 * 首先要找到这个节点，所以还是得比较
		 */
		int result=t.compareTo(node.data);
		
		/**
		 * 去左半部分找这个节点，
		 * 找到节点result==0,这个递归就停止
		 */
		if(result<0){
			node.left=delete(t,node.left);
		}else if(result>0){//去右半部分找这个节点
			node.right=delete(t,node.right);
		}
		/**
		 * 如果这个节点的左右孩子都不为空，那么找到当前节点的后继节点，
		 * 
		 */
		if(node.left!=null && node.right!=null){
			/**
			 * node节点的右子树部分的最小节点，实际上就是它的后继节点
			 * 得到后继节点的值
			 */
			node.data = findMin(node.right).data;  
			/**
			 * 这个过程并不是删除后继节点，是一步一步的把所有的节点都替换上来
			 */
	        node.right = delete(node.data,node.right);  
		}else{
			/**
			 * 如果二叉搜索树中一个节点是完全节点，
			 * 那么它的前驱和后继节点一定在以它为头结点的子树中，应该是这样的
			 * 来到了只有一个头节点和一个子节点的情况
			 */
			node = (node.left!=null)?node.left:node.right; 
		}
		//此处的node，是经过调整后的传入的root节点
		return node;
		
	}
	
	
	/**
	 * 返回二叉树中的最小值节点
	 * 此时无比想念大根堆和小根堆
	 */
	public BinaryNode<T> findMin(BinaryNode node){
		if(node==null)
			return null;	
		/**
		 * 如果node不为空，就递归的去左边找
		 * 最小值节点肯定是左孩子为空的节点
		 */
		if(node.left!=null)
			node=findMin(node.left);
		return node;
	}
	
	/**
	 * 初始化一棵二叉查找树
	 * 层序遍历为{}
	 */
//	public BinaryNode<Integer> init(){
//		
//		return head;
//	}
	
}
