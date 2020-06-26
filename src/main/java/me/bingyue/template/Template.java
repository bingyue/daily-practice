package me.bingyue.template;

import java.util.Arrays;

public class Template {

    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        // 默认都设置为是质数
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {
            //如果当前数为质数，那么它的倍数不是质数
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;
            }
        }
        int count = 0;
        // 遍历一遍
        //0和1不是质数，注意要从2开始!!
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) count++;
        }
        return count;
    }

}
