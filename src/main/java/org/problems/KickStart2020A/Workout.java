package org.problems.KickStart2020A;


/*
Problem
Tambourine has prepared a fitness program so that she can become more fit! The program is made of N sessions. During the i-th session, Tambourine will exercise for Mi minutes. The number of minutes she exercises in each session are strictly increasing.

The difficulty of her fitness program is equal to the maximum difference in the number of minutes between any two consecutive training sessions.

To make her program less difficult, Tambourine has decided to add up to K additional training sessions to her fitness program. She can add these sessions anywhere in her fitness program, and exercise any positive integer number of minutes in each of them. After the additional training session are added, the number of minutes she exercises in each session must still be strictly increasing. What is the minimum difficulty possible?

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the two integers N and K. The second line contains N integers, the i-th of these is Mi, the number of minutes she will exercise in the i-th session.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the minimum difficulty possible after up to K additional training sessions are added.

Limits
Time limit: 20 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
For at most 10 test cases, 2 ≤ N ≤ 105.
For all other test cases, 2 ≤ N ≤ 300.
1 ≤ Mi ≤ 109.
Mi < Mi+1 for all i.
Test set 1
K = 1.

Test set 2
1 ≤ K ≤ 105.
Samples

Input 1

Output 1

1
3 1
100 200 230

Case #1: 50


Input 2

Output 2

3
5 2
10 13 15 16 17
5 6
9 10 20 26 30
8 3
1 2 3 4 5 6 7 10

Case #1: 2
Case #2: 3
Case #3: 1

Sample #1
In Case #1: Tambourine can add up to one session. The added sessions are marked in bold: 100 150 200 230. The difficulty is now 50.

Sample #2
In Case #1: Tambourine can add up to two sessions. The added sessions are marked in bold: 10 11 13 15 16 17 18. The difficulty is now 2.

In Case #2: Tambourine can add up to six sessions. The added sessions are marked in bold: 9 10 12 14 16 18 20 23 26 29 30. The difficulty is now 3.

In Case #3: Tambourine can add up to three sessions. The added sessions are marked in bold: 1 2 3 4 5 6 7 8 9 10. The difficulty is now 1. Note that Tambourine only added two sessions.

Note #1: Only Sample #1 is a valid input for Test set 1. Consequently, Sample #1 will be used as a sample test set for your submissions.
Note #2: Unlike previous editions, in Kick Start 2020, all test sets are visible verdict test sets, meaning you receive instant feedback upon submission.
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Workout {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int testcase = 1; testcase <= t; ++testcase) {
            int N = in.nextInt();//Sessions
            int K = in.nextInt();//New sessions
            int[] difficult = new int[N-1];
            int d1 = in.nextInt();
            for (int i = 1; i < N; i++) {
                int d2 = in.nextInt();
                difficult[i-1] = d2 -d1;
                d1 = d2;
            }
            System.out.println("Case #" + testcase + ": " + binarySearchMinDifficult(K,difficult,1,(int)Math.pow(10,9)));
        }
    }


    private static int binarySearchMinDifficult(int K, int[] d, int min, int max){
        if(max == min){
            return max;
        }
        int mid = min + (max - min) / 2;
        int k =0;
        for (int i = 0; i < d.length; i++) {
            int ki = (int)Math.round(Math.ceil((double)d[i]/mid))-1;
            k += ki;
            if(k > K){
                break;
            }
        }
        if(k <= K){
            return binarySearchMinDifficult(K,d,min,mid);
        }else{
            return binarySearchMinDifficult(K,d,mid+1,max);
        }
    }

    public static int getMinDifficultHeap(int N, int K, int[] difficult){
        ArrayMaxBinaryHeap heap = new ArrayMaxBinaryHeap(N-1 + K);
        for (int i = 0; i < N-1; i++) {
            heap.insert(difficult[i]);
        }
        for (int i = 0; i < K; i++) {
            int max = heap.extractMax();
            if(max%2 == 0){
                int half = max/2;
                heap.insert(half);
                heap.insert(half);
            }else{
                int half = max/2;
                if(half ==0) {
                    heap.insert(1);
                }else{
                    heap.insert(half);
                }
                heap.insert(half+1);
            }
        }

        return heap.getMaxi();
    }

    public static class ArrayMaxBinaryHeap {
        int capacity;
        int arr[];
        int size = 0;

        public ArrayMaxBinaryHeap(int capacity){
            this.capacity = capacity;
            arr = new int[capacity];
        }

        protected int getParent(int i){
            return (i-1)/2;
        }

        protected int getLeftChild(int i){
            return (2*i)+1;
        }

        protected int getRightChild(int i){
            return (2*i)+2;
        }


        /**
         * O(1)
         * @return the min element
         */
        public int getMaxi(){
            return arr[0];
        }

        /**
         * O(Logn)
         * Insert the element
         * @param k
         */
        public void insert(int k){
            int pos = size;
            size++;
            arr[pos] = k;
            reorderUp(pos);
        }

        public void replaceRoot(int k){
            arr[0] = k;
            reorderDown(0);
        }

        /**
         * O(log n)
         * Extract the min element
         * @return
         */
        public int extractMax(){
            int r = getMaxi();
            delete(0);
            return r;
        }
        /**
         * @param k Position in the array of the element to delete
         */
        protected void delete(int k){
            if(k<0 || k > size - 1) throw new ArrayIndexOutOfBoundsException("Index out of the range");
            if(k == size-1){
                arr[size-1] = 0;
                size--;
                return;
            }
            swap(arr,size-1, k);
            arr[size-1] = 0;
            size--;
            reorderUp(k);
            reorderDown(k);

        }

        private void reorderDown(int k){
            if(k >= size-1) return;

            int l = getLeftChild(k);
            int r = getRightChild(k);
            if(l > size-1 && r > size-1) return;

            int w;
            if(l > size-1) w = r;
            else if(r > size-1) w = l;
            else if(arr[l] > arr[r]) w = l;
            else w = r;

            if(arr[k] < arr[w]){
                swap(arr,k,w);
                reorderDown(w);
            }
        }

        private void reorderUp(int k){
            if(k == 0) return;
            int parent = getParent(k);
            if(arr[parent] < arr[k]){
                swap(arr,parent, k);
                reorderUp(parent);
            }
        }

        public static void swap(int[] arr, int elem1, int elem2){
            int tmp = arr[elem1];
            arr[elem1] = arr[elem2];
            arr[elem2] = tmp;
        }


    }



}
