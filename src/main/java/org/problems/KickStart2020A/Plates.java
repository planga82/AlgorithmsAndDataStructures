package org.problems.KickStart2020A;


/*
Problem
Dr. Patel has N stacks of plates. Each stack contains K plates. Each plate has a positive beauty value, describing how beautiful it looks.

Dr. Patel would like to take exactly P plates to use for dinner tonight. If he would like to take a plate in a stack, he must also take all of the plates above it in that stack as well.

Help Dr. Patel pick the P plates that would maximize the total sum of beauty values.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the three integers N, K and P. Then, N lines follow. The i-th line contains K integers, describing the beauty values of each stack of plates from top to bottom.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum total sum of beauty values that Dr. Patel could pick.

Limits
Time limit: 20 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
1 ≤ K ≤ 30.
1 ≤ P ≤ N * K.
The beauty values are between 1 and 100, inclusive.

Test set 1
1 ≤ N ≤ 3.
Test set 2
1 ≤ N ≤ 50.
Sample

Input

Output

2
2 4 5
10 10 100 30
80 50 10 50
3 2 3
80 80
15 50
20 10


Case #1: 250
Case #2: 180


In Sample Case #1, Dr. Patel needs to pick P = 5 plates:

He can pick the top 3 plates from the first stack (10 + 10 + 100 = 120).
He can pick the top 2 plates from the second stack (80 + 50 = 130) .
In total, the sum of beauty values is 250.
In Sample Case #2, Dr. Patel needs to pick P = 3 plates:

He can pick the top 2 plates from the first stack (80 + 80 = 160).
He can pick no plates from the second stack.
He can pick the top plate from the third stack (20).
In total, the sum of beauty values is 180.
Note: Unlike previous editions, in Kick Start 2020, all test sets are visible verdict test sets, meaning you receive instant feedback upon submission.
* */

import org.utils.ArrayUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Plates {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int testcase = 1; testcase <= t; ++testcase) {
            int N = in.nextInt();
            int K = in.nextInt();
            int P = in.nextInt();
            int[][] stacks = new int[N][K];
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < K; i++) {
                    stacks[j][i] = in.nextInt();
                }
            }
            int result = platesDynamic(P, stacks, N, K);
            System.out.println("Case #" + testcase + ": " + result);
        }
    }

    public static int plates(int P, int[][] stacks, int N, int K){
        int[] state = new int[N + 1]; //P + stackIndexes
        state[N] = P;
        HashMap<Integer, Integer> calculated = new HashMap<>();
        return platesBruteForceRecursive(stacks,N,K,state,0, calculated);
    }

    private static int platesDynamic(int P, int[][] stacks, int N, int K){
        int[][] dp = new int[N+1][P+1];
        int[][] sumStacks = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            for (int k = 1; k <= K; k++) {
                sumStacks[i][k] = sumStacks[i][k-1] + stacks[i-1][k-1];
            }
        }
        System.out.println(Arrays.deepToString(sumStacks));
        for (int i = 0; i <= N; i++) {
            for (int p = 0; p <= P; p++) {
                if(i == 0 || p == 0){
                    dp[i][p] = 0;
                }else{
                    for (int k = 0; k <= Math.min(p,K); k++) {
                        dp[i][p] = Math.max(
                                dp[i][p],
                                dp[i-1][p-k] + sumStacks[i][k]);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[N][P];
    }

    public static int platesBruteForceRecursive(int[][] stacks, int N, int K, int[] state, int partialRes, HashMap<Integer, Integer> calculated){

        if(calculated.containsKey(state)){
            return calculated.get(state);
        }
        if(state[N] == 0){
            calculated.put(Arrays.hashCode(state), partialRes);
            return partialRes;
        }
        int res = partialRes;
        for (int i = 0; i < N; i++) {
            if(state[i] < K) {
                int stackIndex = state[i];
                state[i]++;
                state[N]--;
                int resi = platesBruteForceRecursive(stacks, N, K, state, partialRes + stacks[i][stackIndex], calculated);
                state[i]--;
                state[N]++;
                if (resi > res) {
                    res = resi;
                }
            }
        }
        calculated.put(Arrays.hashCode(state), res);
        return res;
    }


}
