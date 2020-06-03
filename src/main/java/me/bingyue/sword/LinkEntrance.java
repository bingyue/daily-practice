package me.bingyue.sword;

import java.util.*;

public class LinkEntrance {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args){

        // 删除首尾空格，分割字符串
        String s="1    3 4 5 ";
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }

        Node root=new Node(100);
//        root.left=new Node(99);
//        root.right=new Node(102);

//        treeToDoublyList(root);

        hammingWeight(10);

    }

    class TreeNode {
   int val;
    TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
    }

    public static int hammingWeight(int n) {
        int res=0;//返回结果
        int mask=1;
        for(int i=0;i<32;i++){
            //任何数字跟掩码 1 进行逻辑与运算，都可以让我们获得这个数字的最低位
            if((n&mask)==1){
                res++;
            }
            //检查下一位时，我们将掩码左移一位
            mask=mask<<1;
        }
//        Integer.toBinaryString()
        return res;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // queue可以存储null
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        // 删除最后的,
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        // 去除两边的括号，转换为字符串数组
        // 从1到data.length() - 1，左闭右开区间
        String[] vals = data.substring(1, data.length() - 1).split(",");
        // 层序遍历第一个就是头结点
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 字符串数组的下标
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }



    static  List<Node>  list=new ArrayList();
    public static Node treeToDoublyList(Node root) {
        if(root==null) return null;
        inOrder(root);
        Node dummy=new Node(-1);
        Node curr=dummy;
        for(Node node:list){
            node.left=curr;
            curr.right=node;
            //更新curr
            curr=curr.right;
        }
        dummy.right.left=null;
        return dummy.right;
    }

    private static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
    public String reverseLeftWords(String s, int n) {

        return s.substring(n) + s.substring(0,n);


    }

    public String addStrings(String num1, String num2) {
        if(num1==null || num1.length()==0){
            return num2;
        }

        if(num2==null || num2.length()==0){
            return num1;
        }

        char[] ch1=num1.toCharArray();
        char[] ch2=num2.toCharArray();
        StringBuilder res=new StringBuilder();
        int carry=0;
        int i=ch1.length-1;
        int j=ch2.length-1;
        while(i>=0 || j>=0){
            int sum=0;
            if(i>=0){
                sum+=ch1[i--];
            }

            if(j>=0){
                sum+=ch2[j--];
            }

            sum+=carry;
            res.append(sum%10);
            carry=sum/10;
        }

        if(carry>0){
            res.append(carry);
        }
        return res.reverse().toString();
    }


    public String minNumber(int[] nums) {
        if(nums.length==0){
            return "";
        }
        StringBuilder res=new StringBuilder();
        List<String> list=new ArrayList();
        for(int num:nums){
            list.add(String.valueOf(num));
        }
        list.sort((x,y)->(x+y).compareTo(y+x));
        for(String str:list){
            res.append(str);
        }
        return res.toString();
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        int n=1;
        int count=10^n-1;
        int count2=(10^n)-1;


        System.out.println(count);
        System.out.println(count2);


        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }
}
