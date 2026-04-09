package com.starlink.backend.dsa.prefixSum.xorAfterQueries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static final int MOD = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = 350; // Thoda optimize kiya block size

        // Step 1: Sirf small queries ko store karne ke liye list
        // Taaki hum har K ke liye 1D array reuse kar sakein
        List<int[]>[] smallKQueries = new ArrayList[B];
        for (int i = 0; i < B; i++) smallKQueries[i] = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if (k >= B) {
                // Large K: Seedha process karo (O(Q * sqrt(N)))
                long val = v;
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) ((1L * nums[i] * val) % MOD);
                }
            } else {
                // Small K: Baad mein process karne ke liye save karo
                smallKQueries[k].add(q);
            }
        }

        // Step 2: Har Small K ke liye 1D array reuse (Memory efficient)
        long[] diff = new long[n + B + 1];
        for (int k = 1; k < B; k++) {
            if (smallKQueries[k].isEmpty()) continue;

            Arrays.fill(diff, 1L);
            for (int[] q : smallKQueries[k]) {
                int l = q[0], r = q[1], v = q[3];
                diff[l] = (diff[l] * v) % MOD;
                int lastIdxInRange = l + ((r - l) / k) * k;
                int nextIdxToStop = lastIdxInRange + k;
                diff[nextIdxToStop] = (diff[nextIdxToStop] * modInverse(v)) % MOD;
            }

            // Prefix product (jump by k) and update nums directly
            for (int i = 0; i < n; i++) {
                if (i >= k) diff[i] = (diff[i] * diff[i - k]) % MOD;
                if (diff[i] != 1) {
                    nums[i] = (int) ((1L * nums[i] * diff[i]) % MOD);
                }
            }
        }

        int xorResult = 0;
        for (int val : nums) xorResult ^= val;
        return xorResult;
    }

    private long modInverse(long n) {
        return power(n, MOD - 2);
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}