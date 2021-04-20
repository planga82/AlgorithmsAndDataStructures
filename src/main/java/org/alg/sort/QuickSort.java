package org.alg.sort;


public class QuickSort {

    /**
     * Quicksort method to order an array
     * Worst case O(n²)
     * Best case O(nlogn)
     * Avg case O(nlogn)
     * No extra space
     *
     * @param arr
     * @return
     */

    public void orderLastElemPivot(int[] arr){
        orderLastElemPivot(arr, 0, arr.length-1);
    }

    public void orderLastElemPivot(Comparable[] arr){
        orderLastElemPivot(arr, 0, arr.length-1);
    }

    public void orderLastElemPivot(int[] arr, int low, int high){
        if(low < high){
            int part = partition(arr, low, high);
            orderLastElemPivot(arr, low, part-1);
            orderLastElemPivot(arr, part +1, high);
        }
    }

    public void orderLastElemPivot(Comparable[] arr, int low, int high){
        if(low < high){
            int part = partition(arr, low, high);
            orderLastElemPivot(arr, low, part-1);
            orderLastElemPivot(arr, part +1, high);
        }
    }

    private int partition(int[] arr, int low, int high){
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

    private int partition(Comparable[] arr, int low, int high){
        int min = low - 1;
        Comparable pivot = arr[high];
        for(int i = low; i < high; i++){
            if(arr[i].compareTo(pivot) < 0){
                min++;
                swap(arr, i, min);
            }
        }
        min++;
        swap(arr, min, high);
        return min;
    }

    private void swap(int[] arr, int elem1, int elem2){
        int tmp = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = tmp;
    }

    private void swap(Comparable[] arr, int elem1, int elem2){
        Comparable tmp = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = tmp;
    }


}
