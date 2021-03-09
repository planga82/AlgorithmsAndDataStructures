package org.alg.search;

import org.alg.sort.ArrayMergeSort;

public class KthSmallest {

    /**
     * Using MergeSort
     * O(nlogn)
     * @param arr
     * @param k
     * @return
     */
    public static int simple(int[] arr, int k){
        ArrayMergeSort.order(arr,0, arr.length -1);
        return arr[k-1];
    }
}
