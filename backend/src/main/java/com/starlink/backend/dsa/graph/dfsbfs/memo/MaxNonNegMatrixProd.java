package com.starlink.backend.dsa.graph.dfsbfs.memo;

public class MaxNonNegMatrixProd {
// https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/?envType=daily-question&envId=2026-03-23
        int MOD = 1000000007;
        Long[][][] memo;  // memo[i][j][0] = max, memo[i][j][1] = min

        public int maxProductPath(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            memo = new Long[m][n][2];

            long[] result = solve(grid, m-1, n-1);

            return result[0] < 0 ? -1 : (int)(result[0] % MOD);
        }

        private long[] solve(int[][] grid, int i, int j) {
            if(i == 0 && j == 0) {
                return new long[]{grid[0][0], grid[0][0]};
            }

            if(memo[i][j][0] != null) {
                return new long[]{memo[i][j][0], memo[i][j][1]};
            }

            long maxVal = Long.MIN_VALUE;
            long minVal = Long.MAX_VALUE;

            // From top
            if(i > 0) {
                long[] top = solve(grid, i-1, j);
                long val1 = top[0] * grid[i][j];
                long val2 = top[1] * grid[i][j];
                maxVal = Math.max(maxVal, Math.max(val1, val2));
                minVal = Math.min(minVal, Math.min(val1, val2));
            }

            // From left
            if(j > 0) {
                long[] left = solve(grid, i, j-1);
                long val1 = left[0] * grid[i][j];
                long val2 = left[1] * grid[i][j];
                maxVal = Math.max(maxVal, Math.max(val1, val2));
                minVal = Math.min(minVal, Math.min(val1, val2));
            }

            memo[i][j][0] = maxVal;
            memo[i][j][1] = minVal;

            return new long[]{maxVal, minVal};
        }
    }