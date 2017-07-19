package com.lixiong;

/**
 * 冒泡排序最终版
 * 冒泡排序是一种交换排序，它的基本思想是：
 * 两两比较相邻记录的关键字，如果反序则交换，直到没有反序的记录为止。
 * 算法复杂度分析：
 * 使用优化后的冒泡排序，最好的情况下，仅需要n - 1次比较，时间复杂度为O(n)；最坏情况下，需要n(n - 1)/2次比较和交换；
 * 所以平均时间复杂度为O(n2)。
 * Created by Administrator on 2017/7/8.
 */

public class BubbleSort {

    // 冒泡排序优化，如果经过一轮发现已经是有序的，就不再进行排序
    public static void bubbleSortBetter(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        boolean flag = true;
        for (int i = 1, size = array.length; i < size && flag; ++i) {
            flag = false;
            for (int j = size - 1; j >= i; --j) {//经过一轮循环，发现两两已经是有序的了，就置为false
                if (array[j] < array[j - 1]) {
                    CommonUtil.swap(array, j, j - 1);
                    flag = true;
                }
            }
        }
    }
}
