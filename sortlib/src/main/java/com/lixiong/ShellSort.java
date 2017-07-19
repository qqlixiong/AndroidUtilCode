package com.lixiong;

/**
 * 希尔排序
 * 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。希尔排序是非稳定排序算法。
 *希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。这样可以让一个元素可以一次性地朝最终位置前进一大步。然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，但是到了这步，需排序的数据几乎是已排好的了（此时插入排序较快）。
 *
 *更好的理解方式
 *将数组列在一个表中并对行排序（用插入排序）。重复这过程，不过每次用更小的列来进行。最后整个表就只有一列了。
 *将数组转换至表是为了更好地理解这算法，算法本身仅仅对原数组进行排序（通过增加索引的步长，例如是用i += step_size而不是i++）。
 *比如第一次放在5列中对每行使用快速排序排序，第二次放在3列中，最后放在1列中。类比于步长从5到3再到1。
 *
 *算法复杂度分析
 *希尔排序的算法复杂度和增量序列有关，只要最终步长为1任何步长序列都可以工作。可以参加希尔排序。
 * Created by Administrator on 2017/7/8.
 */

public class ShellSort {

    public static void shellSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        //计算步长
        int gap = 1, size = array.length;
        while (gap < size / 3) {
            gap = gap * 3 + 1; // O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        }

        while (gap > 0) {

            for (int i = gap, j, temp; i < size; ++i) {
                temp = array[i];
                for (j = i - gap; j >= 0 && array[j] > temp; j -= gap) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;
            }

            gap /= 3;
        }
    }
}
