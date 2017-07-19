package com.lixiong;

/**
 * 基数排序
 * Created by Administrator on 2017/7/8.
 */

public class RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) return;

        /*
            1. 计算最大位数
         */
        int maxBit = maxBit(arr);
        System.out.println(maxBit);

        /*
            2. 获取每一位，使用计数排序进行排序
         */
        int j, k, radix = 1, length = arr.length;
        int[] count = new int[10]; // 0 ~ 9
        int[] temp = new int[length];

        for (int i = 1; i <= maxBit; ++i) {

            for (j = 0; j < 10; ++j) {
                count[j] = 0; //初始化
            }

            //统计位数为i的个数
            for (j = 0; j < length; ++j) {
                k = (arr[j] / radix) % 10;
                ++count[k];
            }

            // 位数小于等于i的个数
            for (j = 1; j < 10; ++j) {
                count[j] = count[j] + count[j - 1];
            }

            //开始排序
            for (j = length - 1; j >= 0; j--) {//将所有桶中记录依次收集到tmp中
                k = (arr[j] / radix) % 10;
                temp[count[k] - 1] = arr[j];
                count[k]--;
            }

            for (j = 0; j < length; ++j) {
                arr[j] = temp[j];
            }

            radix *= 10;
        }

    }

    private static int maxBit(int[] arr) {
        int max = arr[0];
        for (int i = 1, length = arr.length; i < length; ++i) {
            max = arr[i] > max ? arr[i] : max;
        }

        int maxBit = 0;
        while (max >= 1) {
            maxBit++;
            max /= 10;
        }

        return maxBit;
    }
}
