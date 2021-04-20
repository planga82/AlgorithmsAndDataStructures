package org.alg.sort;

import org.utils.ArrayUtils;

public class BubbleSort {

    /**
     * BubblueSort method to order an array
     * Worst case O(n²)
     * Best case O(n)
     * Avg case O(n²)
     * No extra space
     *
     * @param arr
     * @return
     */
    public void order(int[] arr){
        boolean ordered=false;
        while (!ordered){
            ordered = true;
            int i=0; int j=1;
            while(j < arr.length){
                if(arr[i] > arr[j]){
                    ordered = false;
                    swap(arr, i, j);
                }
                i++; j++;
            }
        }

    }

    public void order(Comparable[] arr){
        boolean ordered=false;
        while (!ordered){
            ordered = true;
            int i=0; int j=1;
            while(j < arr.length){
                if(arr[i].compareTo(arr[j]) > 0){
                    ordered = false;
                    swap(arr, i, j);
                }
                i++; j++;
            }
        }

    }

    private void swap(int[] arr, int i, int j){
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    private void swap(Comparable[] arr, int i, int j){
        Comparable aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }



}
