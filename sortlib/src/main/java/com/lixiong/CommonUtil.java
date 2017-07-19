package com.lixiong;

/**
 * Created by Administrator on 2017/7/8.
 */

public class CommonUtil {

    public static void swap(int[] array, int j, int i) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
