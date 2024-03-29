package com.example.demo.util;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static int[] bubbleSort(int array[]) {

        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = BubbleSort.bubbleSort(new int[]{1, 6, 3, 8, 7});
        System.out.println(Arrays.toString(a));
    }
}
