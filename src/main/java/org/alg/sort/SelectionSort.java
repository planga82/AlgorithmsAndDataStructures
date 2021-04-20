package org.alg.sort;

public class SelectionSort {

    /**
     * SelectionSort method to order an array
     * Worst case O(n²)
     * Best case O(n²)
     * Avg case O(n²)
     * No extra space
     *
     * @param arr
     * @return
     */
    public void order(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public void order(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min].compareTo(arr[j]) > 0){
                    min = j;
                }
            }
            swap(arr, min, i);
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
