package org.alg.sort;

import org.utils.ArrayUtils;

public class ArrayQuickSort {

    /**
     * Quicksort method to order an array
     * Worst case O(n²)
     * Best case O(nlogn)
     * Avg case O(nlogn)
     * No extra space
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static void orderLastElemPivot(int[] arr, int low, int high){
        if(low < high){
            int part = partition(arr, low, high);
            orderLastElemPivot(arr, low, part-1);
            orderLastElemPivot(arr, part +1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int min = low - 1;
        int pivot = arr[high];
        for(int i = low; i < high; i++){
            if(arr[i] < pivot){
                min++;
                ArrayUtils.swap(arr, i, min);
            }
        }
        min++;
        ArrayUtils.swap(arr, min, high);
        return min;
    }


}
