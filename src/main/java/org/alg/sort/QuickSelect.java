package org.alg.sort;


public class QuickSelect {

    /**
     * Quicksort method to order an array
     * Avg case O(n)
     * No extra space
     *
     * @param arr
     * @return
     */

    public int select(int[] arr, int pos){
        return select(arr, 0, arr.length-1, pos);
    }

    public Comparable select(Comparable[] arr, int pos){
        return select(arr, 0, arr.length-1, pos);
    }

    public int select(int[] arr, int low, int high, int pos){
        int part = partition(arr, low, high);
        if(part == pos){
            return arr[pos];
        }else if(pos < part) {
            return select(arr, low, part - 1, pos);
        } else {
            return select(arr, part + 1, high, pos);
        }
    }

    public Comparable select(Comparable[] arr, int low, int high, int pos){
        int part = partition(arr, low, high);
        if(part == pos){
            return arr[pos];
        }else if(pos < part) {
            return select(arr, low, part - 1, pos);
        } else {
            return select(arr, part + 1, high, pos);
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
