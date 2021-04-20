package org.problems.yamcode.round1;


/*

 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RevertSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int testcase = 1; testcase <= t; ++testcase) {
            int N = in.nextInt();
            int[] L = new int[N];
            for (int j = 0; j < N; j++) {
                L[j] = in.nextInt();
            }
            System.out.println("Case #" + testcase + ": " + getResult(L,N));
        }
    }

    public static int getResult(int[] L, int N){
        int[] Lordered = new int[N];
        for (int i = 0; i < N; i++) {
            Lordered[i] = L[i];
        }

        quickSort(Lordered, 0, N-1);

        int total = 0;

        for (int i = 0; i < N-1; i++) {
            int j = i;
            while(L[j] != Lordered[i]){
                j++;
            }
            total = total + j - i + 1;
            quickSort(L, i, j);
        }
        return total;
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int part = partition(arr, low, high);
            quickSort(arr, low, part-1);
            quickSort(arr, part +1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
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

    public static void swap(int[] arr, int elem1, int elem2){
        int tmp = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = tmp;
    }



}
