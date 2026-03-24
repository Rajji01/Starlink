package com.starlink.backend.dsa.prefixSum;
//https://leetcode.com/problems/construct-product-matrix/?envType=daily-question&envId=2026-03-24
public class ConstructProductMatrix {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int MOD = 12345;
        int[][] ans = new int[n][m];

        // Pass 1: Calculate product of all elements before current cell
        long prefix = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans[i][j] = (int)prefix;
                prefix = (prefix * grid[i][j]) % MOD;
            }
        }

        // Pass 2: Multiply with product of all elements after current cell
        long suffix = 1;
        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                ans[i][j] = (int)((ans[i][j] * suffix) % MOD);
                suffix = (suffix * grid[i][j]) % MOD;
            }
        }

        return ans;
    }
}
