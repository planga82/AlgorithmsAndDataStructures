package org.alg.sort;

public class ArrayMergeSort {

    /**
     * Quicksort method to order an array
     * All cases O(nlogn)
     * Extra space O(n)
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static void order(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = low + (high - low) / 2;
        order(arr,low,mid);
        order(arr,mid+1,high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high){
        int[] arr1 = new int[mid - low + 1];
        int[] arr2 = new int[high - mid];

        int index = 0;
        for(int i=low; i <= mid; i++){
            arr1[index] = arr[i];
            index++;
        }

        index = 0;
        for(int i=mid+1; i <= high; i++){
            arr2[index] = arr[i];
            index++;
        }

        int index1 =0;
        int index2 =0;
        for(int i=low; i<=high; i++){
            if(index1 >= arr1.length){
                arr[i] = arr2[index2];
                index2++;
            }else if(index2 >= arr2.length){
                arr[i] = arr1[index1];
                index1++;
            }else if(arr1[index1] < arr2[index2]){
                arr[i] = arr1[index1];
                index1++;
            }else{
                arr[i] = arr2[index2];
                index2++;
            }
        }
    }


}
