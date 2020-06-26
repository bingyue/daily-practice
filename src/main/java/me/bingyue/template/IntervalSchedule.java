package me.bingyue.template;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 区间调度问题
 */
public class IntervalSchedule {

    //求最多有几个区间不相交
    public int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) return 0;
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {  //发现一个不相交的，加一
                // 找到下一个选择的区间了
                count++;
                //更新下一个x的值
                x_end = interval[1];
            }
        }
        return count;
    }

}
