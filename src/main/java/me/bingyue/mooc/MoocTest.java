package me.bingyue.mooc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MoocTest {

    public int kthSmallest(int[][] matrix, int k) {
        // 使用最大堆就可以
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }

        });
        for (int[] row : matrix) {
            for (int num : row) {
                //优化下
                pq.add(num);
                if(pq.size()>k){
                    pq.remove();
                }

            }
        }

        //此时堆顶的就是第k小的
        return pq.remove();
    }


    public int search(int[] A, int target) {
        int left = 0, right = A.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == A[mid]) {
                return mid;
            }

            if (A[mid] < A[A.length - 1]) {//右边有序
                if (target > A[mid] && target <= A[A.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {//左边有序
                //  这个A[0] <= target有什么用呢，需要保证这个target大于左边界
                // 也就是在这个边界里，上边也一样
                if (target < A[mid] && A[0] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        //  找不到，返回-1
        return -1;
    }

    public static void main(String[] args) {
        minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (r < nums.length) {
            if (sum >= s && l + 1 < nums.length) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l];
                l++;
            } else {
                sum += nums[r];
                r++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }


}
