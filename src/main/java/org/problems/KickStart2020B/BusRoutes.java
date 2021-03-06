package org.problems.KickStart2020B;


/*
Problem
Bucket is planning to make a very long journey across the countryside by bus. Her journey consists of N bus routes, numbered from 1 to N in the order she must take them. The buses themselves are very fast, but do not run often. The i-th bus route only runs every Xi days.

More specifically, she can only take the i-th bus on day Xi, 2Xi, 3Xi and so on. Since the buses are very fast, she can take multiple buses on the same day.

Bucket must finish her journey by day D, but she would like to start the journey as late as possible. What is the latest day she could take the first bus, and still finish her journey by day D?

It is guaranteed that it is possible for Bucket to finish her journey by day D.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the two integers N and D. Then, another line follows containing N integers, the i-th one is Xi.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the latest day she could take the first bus, and still finish her journey by day D.

Limits
Time limit: 10 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
1 ≤ Xi ≤ D.
1 ≤ N ≤ 1000.
It is guaranteed that it is possible for Bucket to finish her journey by day D.
Test set 1
1 ≤ D ≤ 100.
Test set 2
1 ≤ D ≤ 1012. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BusRoutes {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int testcase = 1; testcase <= t; ++testcase) {
            int N = in.nextInt();
            long D = in.nextLong();
            long[] x = new long[N];
            for (int i = 0; i < N; i++) {
                x[i] = in.nextLong();
            }
            System.out.println("Case #" + testcase + ": " + minDayStart(N, D,x));
        }
    }

    public static long minDayStart(int N, long D,  long[] x){
        long d = D;
        for (int i = N-1; i >= 0; i--) {
            d = d - (d % x[i]);
        }
        return d;
    }




}
