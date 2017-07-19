package com.lixiong;

/**
 * 快速排序
 * Created by Administrator on 2017/7/8.
 */

public class QuickSortWhile {
    private static final int MAX_LIMIT = 4;

    public static void quickSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        quick_sort_recursive(array, 0, array.length - 1);
    }

    private static void quick_sort_recursive(int[] arr, int start, int end) {
        if (end - start <= MAX_LIMIT) {
            // 到达一定程度的小数组时使用插入排序
            insertSort(arr, start, end);
            return;
        }

        while (start < end) { //尾递归优化
            int pivot = partition(arr, start, end);

            quick_sort_recursive(arr, start, pivot - 1);

            start = pivot + 1;
        }
    }

    /*
       分区操作：将arr[end]作为中轴，比它小的放在前面，比它大的放在后面
    */
    private static int partition(int[] arr, int start, int end) {
        int pivotKey = arr[end];

        int left = start, right = end - 1;

        while (left < right) {

            while (arr[left] <= pivotKey && left < right) left++;
            while (arr[right] >= pivotKey && left < right) right--;

            if (left < right) {
                CommonUtil.swap(arr, left, right);
            }
        }

        if (arr[left] >= pivotKey) {
            CommonUtil.swap(arr, left, end);
        } else {
            left++;
        }

        return left;
    }

    //插入排序
    private static void insertSort(int[] arr, int start, int end) {

        for (int i = start + 1, j, temp; i <= end; ++i) {
            temp = arr[i];
            j = i - 1;

            while (j >= start && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }

    }
}
