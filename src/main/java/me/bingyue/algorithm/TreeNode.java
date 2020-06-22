package me.bingyue.algorithm;

public class TreeNode {
	
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
		}
	
	TreeNode(TreeNode left,TreeNode right,int value){
		this.val=value;
		this.left=left;
		this.right=right;
	}
}
