package org.alg.dynamic;

import java.util.Arrays;

public class KnapSack {

    public static int resolve(int W, int N, int[] weights, int[] values){
        int[][] dp = new int[N+1][W+1];
        for (int i = 0; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                if(w == 0 || i == 0){
                    dp[i][w] = 0;
                }else {
                    if (weights[i-1] > w) {
                        dp[i][w] = dp[i - 1][w];
                    } else {
                        dp[i][w] = Math.max(
                                dp[i - 1][w],
                                values[i-1] + dp[i - 1][w - weights[i-1]]);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[N][W];
    }
}
