package org.problems.KickStart2020A;


/*
Problem
There are N houses for sale. The i-th house costs Ai dollars to buy. You have a budget of B dollars to spend.

What is the maximum number of houses you can buy?

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a single line containing the two integers N and B. The second line contains N integers. The i-th integer is Ai, the cost of the i-th house.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum number of houses you can buy.

Limits
Time limit: 15 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
1 ≤ B ≤ 105.
1 ≤ Ai ≤ 1000, for all i.
Test set 1
1 ≤ N ≤ 100.
Test set 2
1 ≤ N ≤ 105.
Sample

Input

Output

3
4 100
20 90 40 90
4 50
30 30 10 10
3 300
999 999 999


Case #1: 2
Case #2: 3
Case #3: 0


In Sample Case #1, you have a budget of 100 dollars. You can buy the 1st and 3rd houses for 20 + 40 = 60 dollars.
In Sample Case #2, you have a budget of 50 dollars. You can buy the 1st, 3rd and 4th houses for 30 + 10 + 10 = 50 dollars.
In Sample Case #3, you have a budget of 300 dollars. You cannot buy any houses (so the answer is 0).
 */

import java.util.*;
import java.io.*;

public class Allocation {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int testcase = 1; testcase <= t; ++testcase) {
            int N = in.nextInt();//numHouses
            int B = in.nextInt();//budget
            int[] prices = new int[N];
            for (int j = 0; j < N; j++) {
                prices[j] = in.nextInt();
            }
            System.out.println("Case #" + testcase + ": " + getResult(prices,B));
        }
    }

    public static int getResult(int[] prices, int B){
        order(prices,0,prices.length-1);
        int result =0;
        for (int i = 0; i < prices.length; i++) {
            if(B >= prices[i]){
                B = B - prices[i];
                result ++;
            }else{
                break;
            }
        }
        return result;
    }

    public static void printArray(int[] arr, int low, int high){
        System.out.print("[");
        for (int i = low; i <= high; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }


    public static void order(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = low + (high - low) / 2;
        order(arr,low,mid);
        order(arr,mid+1,high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high){
        int[] arr1 = new int[mid - low + 1];
        int[] arr2 = new int[high - mid];

        int index = 0;
        for(int i=low; i <= mid; i++){
            arr1[index] = arr[i];
            index++;
        }

        index = 0;
        for(int i=mid+1; i <= high; i++){
            arr2[index] = arr[i];
            index++;
        }

        int index1 =0;
        int index2 =0;
        for(int i=low; i<=high; i++){
            if(index1 >= arr1.length){
                arr[i] = arr2[index2];
                index2++;
            }else if(index2 >= arr2.length){
                arr[i] = arr1[index1];
                index1++;
            }else if(arr1[index1] < arr2[index2]){
                arr[i] = arr1[index1];
                index1++;
            }else{
                arr[i] = arr2[index2];
                index2++;
            }
        }
    }

//    public static void order(int[] arr, int rangeElemnts, int B, int numCase){
//        int[] counts = new int[rangeElemnts];
//        //Count elements
//        for (int i = 0; i < arr.length; i++) {
//            counts[arr[i]]++;
//        }
//
//        int result =0;
//        int b = B;
//        for (int i = 0; i < counts.length; i++) {
//            for (int j = 0; j < counts[i]; j++) {
//                if(b - i >= 0){
//                    b = b-i;
//                    result++;
//                }else{
//                    System.out.println("Case #" + numCase + ": " + result);
//                    return;
//                }
//            }
//        }
//    }

}
