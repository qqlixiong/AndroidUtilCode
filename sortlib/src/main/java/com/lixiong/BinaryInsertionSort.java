package com.lixiong;

/**
 * 二分插入排序
 * 二分（折半）插入排序是一种在直接插入排序算法上进行小改动的排序算法。其与直接排序算法最大的区别在于查找插入位置时使用的是二分查找的方式，在速度上有一定提升。
 *算法复杂度分析：
 *插入每个记录需要O(log i)比较，最多移动i+1次，最少2次。最佳情况O(n log n)，最差和平均情况O(n^2)。
 *总排序码比较次数比直接插入排序的最差情况好得多，但比最好情况要差，所元素初始序列已经按排序码接近有序时，直接插入排序比二分插入排序比较次数少
 * Created by Administrator on 2017/7/8.
 */

public class BinaryInsertionSort {

    public static void binaryInsertionSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        int temp, left, right, middle;
        for (int i = 1, size = array.length; i < size; i++) {
            temp = array[i];
            left = 0;
            right = i - 1;

            //寻找合适的位置
            while (left <= right) {
                middle = (left + right) / 2;
                if (array[middle] > temp) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }

            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }

            array[left] = temp;
        }

    }
}
