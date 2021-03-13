package org.alg.search;

import org.alg.sort.ArrayMergeSort;
import org.structures.heaps.ArrayMaxBinaryHeap;
import org.structures.heaps.ArrayMinBinaryHeap;
import org.utils.ArrayUtils;

import java.util.Random;

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

    /**
     * Using heap min
     * =O(n + klogn)
     * @param arr
     * @param k
     * @return
     */
    public static int extractWithMinHeap(int[] arr, int k){
        ArrayMinBinaryHeap heap = new ArrayMinBinaryHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        for (int i = 0; i < k-1; i++) {
            heap.extractMin();
        }
        return heap.extractMin();
    }

    /**
     * O(k + (n-k)*Logk
     * @param arr
     * @param k
     * @return
     */
    public static int extractWithMaxHeap(int[] arr, int k){
        ArrayMaxBinaryHeap heap = new ArrayMaxBinaryHeap(k);
        for (int i = 0; i < k; i++) {
            heap.insert(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(arr[i] < heap.getMaxi()){
                heap.replaceRoot(arr[i]);
            }
        }
        return heap.getMaxi();
    }

    /**
     * O(n) on Avg
     * O(n2) worst
     * @param arr
     * @param k
     * @return
     */
    public static int quickSelect(int[] arr, int k){
        return quickSelect(arr, 0, arr.length-1, k - 1, "last");
    }

    /**
     * O(n) on Avg
     * O(n2) worst
     * @param arr
     * @param k
     * @return
     */
    public static int randomizedQuickSelect(int[] arr, int k){
        return quickSelect(arr, 0, arr.length-1, k - 1, "random");
    }

    private static int quickSelect(int[] arr, int low, int high, int k, String pivotMode){
        if(high == low){
            return arr[low];
        }

        ArrayUtils.printArray(arr, low,high);
        int pivotelem = partition(arr, low, high, getPivot(pivotMode, low, high));
        System.out.println(low + "," + high + "," + pivotelem);
        ArrayUtils.printArray(arr, low,high);
        if(pivotelem == k) return arr[k];
        if(pivotelem > k) return quickSelect(arr, low, pivotelem -1, k, pivotMode);
        if(pivotelem < k) return quickSelect(arr, pivotelem +1, high, k, pivotMode);
        return -1;
    }

    private static int getPivot(String pivotMode, int low, int high){
        switch (pivotMode){
            case "last": return high;
            case "random": {
                Random rn = new Random();
                return rn.nextInt(high - low + 1) + low;
            }
            default: throw new RuntimeException("No correct value");
        }
    }

    private static int partition(int[] arr, int low, int high, int pivotIndex){
        int minIndex = low-1;
        swap(arr, high, pivotIndex);
        int pivotElem = arr[high];
        for (int i = low; i < high ; i++) {
            if(arr[i] < pivotElem){
                minIndex++;
                swap(arr, minIndex, i);
            }
        }
        minIndex++;
        swap(arr, minIndex, high);
        return minIndex;
    }

    private static void swap(int[] arr, int i, int j){
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}
