package bingyue.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历二叉树
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
   return its level order traversal as:
   [[3],[9,20],[15,7]]
 * @Title: LevelOrderTraversal 
 * @Description: TODO
 */
public class LevelOrderTraversal {

	/**
	 * 实质是二叉树的广度优先搜索
	 * 利用一个辅助队列保存被访问的当前节点的左右孩子，
	 * 调整进出队列的顺序以实现层序遍历
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> result=new ArrayList<>();
		 
         if(root==null){
        	return result; 
         }
        
        /**
         * 一般来说，队列的实现选择LinkedList即可
         * 队列保存节点就不用找什么变量了
         */
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        //首先把头结点的值保存到结果集，然后把左右子节点分别进入队列
       while(!queue.isEmpty()){//需要使用isEmptyy判断，不能使用null
    	   List<Integer> temp=new ArrayList<>();
    	   /**
    	    * error!这里对进行循环的过程，队列长度是在不断变化的
    	    * size需要等于队列出队前的长度
    	    */
    	   int size =queue.size();
    	   for(int i=0;i<size;i++){
    		   TreeNode node=queue.poll();
    		   temp.add(node.val);
    		   if(node.left!=null)
    		     queue.offer(node.left);
    		   if(node.right!=null)
    		     queue.offer(node.right); 
    	   }
    	   //当前队列全部poll，到这里已经完成了一层的遍历
    	   result.add(temp);
       }
		return result;
    }
}
