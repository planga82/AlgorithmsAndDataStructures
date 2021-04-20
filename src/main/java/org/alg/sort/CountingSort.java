package org.alg.sort;

import java.util.HashMap;

public class CountingSort {


    /**
     * Worst case O(n + k)
     * Space O(n + K)
     * @param arr
     * @param rangeElements
     * @return
     */
    public int[] order(int[] arr, int rangeElements){
        int[] counts = new int[rangeElements];
        //Count elements
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }

        int[] out = new int[arr.length];
        int index =0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                out[index] = i;
                index++;
            }
        }
        return out;
    }


}
