package me.bingyue.practice.nowcoder;

import java.util.LinkedList;

/**
 * 对于一个int数组，请编写一个归并排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 *
 * @Title: QuickSort
 */
public class QuickSort {

    class Solution {
        public int longestArithSeqLength(int[] A) {
            int m = A.length;
            // dp[i][j]是以i结尾,且公差为j的最长等差子序列的长度
            int[][] dp = new int[m][20002];
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = i - 1; j >= 0; j--) {

                    int a = A[i] - A[j];
                    if (a < 0) {
                        dp[i][1000 + a * -1] = Math.max(dp[j][1000 + a * -1] + 1, dp[i][1000 + a * -1]);
                        res = Math.max(res, dp[i][1000 + a * -1]);
                    } else {
                        dp[i][a] = Math.max(dp[j][a] + 1, dp[i][a]);
                        res = Math.max(dp[i][a], res);
                    }
                }
            }
            return res + 1;
        }
    }


    public int[] quickSort(int[] A) {
        LinkedList<Integer> adj[]; // 邻接表

//		adj[0]
        // write code here
        return A;
    }

    public static void sort(int[] a, int start, int end) {
        if (start > end) {
            //如果只有一个元素，就不用再排下去了
            return;
        } else {


            //如果不止一个元素，继续划分两边递归排序下去
            int partition = divide(a, start, end);
            sort(a, start, partition - 1);
            sort(a, partition + 1, end);
        }

    }

    //	将数组的某一段元素进行划分，小的在左边，大的在右边
    private static int divide(int[] a, int start, int end) {
        //每次都以最右边的元素作为基准值
        int base = a[end];
        while (start < end) {


        }
        return base;

    }

}
