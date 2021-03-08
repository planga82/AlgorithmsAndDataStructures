package org.alg.sort;

public class ArrayQuickSort {

    /**
     * Quicksort method to order an array
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
                swap(arr, i, min);
            }
        }
        min++;
        swap(arr, min, high);
        return min;
    }

    private static void swap(int[] arr, int elem1, int elem2){
        int tmp = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = tmp;
    }
}
