package com.lixiong;

/**
 * 简单选择排序
 * 选择排序的基本思想：
 * 每一次遍历时选取关键字最小的记录作为有序序列的第i个记录。
 * 算法复杂度分析
 * 简单选择排序最大的特点就是交换移动数据次数少，但它的比较次数是和数组本身是否有序是无关的，即无论最好最差的情况，
 * 都要进行n(n-1)/2次比较；在最好的情况下，不需要进行交换，在最坏的情况下，进行n-1次交换。
 * 所以平均时间复杂度为O(n2)。
 * Created by Administrator on 2017/7/8.
 */

public class SimpleSelectionSort {
    public static void simpleSelectionSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        for (int i = 0, size = array.length; i < size; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < size; ++j) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                CommonUtil.swap(array, i, minIndex);
            }
        }
    }
}
