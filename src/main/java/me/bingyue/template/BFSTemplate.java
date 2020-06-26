package me.bingyue.template;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSTemplate {
    class Node{
        int val;
        //adjacency 对比图的邻接矩阵方式
        Node[] adj;
    }

    // 计算从起点 start 到终点 target 的最近距离
    public int  bfs(Node start,Node target){
        Queue<Node> q=new LinkedList<>();// 核心数据结构
        Set<Node> visited=new HashSet();// 避免走回头路
        int step=0;// 记录扩散的步数
        q.offer(start);// 将起点加入队列
        visited.add(start);
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                Node cur=q.poll();
                /* 划重点：这里判断是否到达终点 */
                if(cur==target)
                    return step;
                /* 将 cur 的相邻节点加入队列 */
                for(Node node:cur.adj){
                    if(!visited.contains(node)){
                        q.offer(node);
                        visited.add(node);
                    }
                }
            }
            /* 划重点：更新步数在这里 */
            step++;
        }
        return step;
    }
}
