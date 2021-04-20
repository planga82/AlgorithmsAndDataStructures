package org.utils;

public class ArrayUtils {
    public static void swap(int[] arr, int elem1, int elem2){
        int tmp = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = tmp;
    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }

    public static void printArray(int[] arr, int low, int high){
        System.out.print("[");
        for (int i = low; i <= high; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }

    public static void swap(Comparable[] arr, int elem1, int elem2){
        Comparable tmp = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = tmp;
    }

    public static void printArray(Comparable[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }

    public static void printArray(Comparable[] arr, int low, int high){
        System.out.print("[");
        for (int i = low; i <= high; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }
}
