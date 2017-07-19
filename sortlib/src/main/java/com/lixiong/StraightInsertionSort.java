package com.lixiong;

/**
 * 直接插入排序
 * 直接插入排序的基本操作：
 * 将一个记录插入到已经排好序的有序表中，从而得到一个新的、记录递增1的有序表。
 * 插入排序是进行值移动，而是不值交换。所以在量较小的情况下插入排序性能要优于冒泡和简单选择排序。
 * 算法复杂度分析：
 * 在最好的情况下，只需进行比较n - 1次，无需进行移动；
 * 在最坏的情况下，比较(n + 2)(n - 1)/2次，交换(n + 4)(n - 1)/2次。
 * 所以平均时间复杂度O(n2)
 * Created by Administrator on 2017/7/8.
 */

public class StraightInsertionSort {

    public static void straightInsertionSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        // 默认array[0]是有序的，将剩下的插入到该有序数组中
        for (int i = 1, j, temp, size = array.length; i < size; ++i) {

            // if (array[i] < array[i - 1]) { //如果小于，将array[i]插入该有序数组中，可以不用判断

            //寻找合适的j
            j = i - 1;
            temp = array[i];//需要一个辅助空间，赋值操作也是移动操作

            // 边移动边查找，可以使用二分查找法
            while (j >= 0 && array[j] > temp) { //持续移动，直到找到合适的位置
                array[j + 1] = array[j];//向后移
                --j;
            }

            array[j + 1] = temp;//移动
        }
        //}

    }

    //for循环
    public static void straightInsertionSort2(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        for (int i = 1, j, temp, size = array.length; i < size; ++i) {
            temp = array[i];
            for (j = i - 1; j >= 0 && array[j] > temp; --j) {
                array[j + 1] = array[j];//移动而非交换
            }
            array[j + 1] = temp;
        }
    }
}
