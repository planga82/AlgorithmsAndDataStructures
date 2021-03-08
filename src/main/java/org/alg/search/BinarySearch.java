package org.alg.search;

public class BinarySearch {

    /**
     * Given an array of elements return the position of the element elem
     * Complexity: O(log n)
     *
     * @param arr
     * @param elem
     * @return
     */
    public static int search(int[] arr, int elem){
        int ini = 0;
        int end = arr.length -1;
        int ret = -1;

        if(elem > arr[end] || elem < arr[ini]){
            return -1;
        }
        while(ini <= end){
            int mid = ((end - ini) / 2) + ini;
            if(arr[mid] == elem){
                return mid;
            }
            if(elem < arr[mid]){
               end = mid - 1;
            }else if(arr[mid] < elem){
                ini = mid + 1;
            }
        }
        return ret;
    }
}
