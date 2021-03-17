package org.alg.sort;

public class CountingSort {


    public static int[] order(int[] arr, int rangeElemnts){
        int[] counts = new int[rangeElemnts];
        //Count elements
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        //Swift  count[0] = 0  count[i]=count[i-1] **Starting indexes**
        //Construct output
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
