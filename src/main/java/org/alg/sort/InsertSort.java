package org.alg.sort;

public class InsertSort {

    /**
     * InsertSort method to order an array
     * Worst case O(n²)
     * Best case O(n)
     * Avg case O(n²)
     * No extra space
     *
     * @param arr
     * @return
     */
    public void order(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > pick) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = pick;
        }
    }

    public void order(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            Comparable pick = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(pick) > 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = pick;
        }
    }
}
