package bingyue.util;

/**
 * 普通二叉树节点
 */
public class TreeNode {

	private int value;//
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(TreeNode left,TreeNode right,int value){
		this.value=value;
		this.left=left;
		this.right=right;
	}
	
}
