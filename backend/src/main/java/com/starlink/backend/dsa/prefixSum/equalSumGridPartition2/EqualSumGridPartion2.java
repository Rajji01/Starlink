package com.starlink.backend.dsa.prefixSum.equalSumGridPartition2;

import java.util.HashMap;

public class EqualSumGridPartion2 {

    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long totalSum = 0;

        HashMap<Long, Integer> totalFreq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                totalSum += grid[i][j];
                totalFreq.merge((long) grid[i][j], 1, Integer::sum);
            }
        }

        // ============ HORIZONTAL CUT ============
        long currentRowSum = 0;
        HashMap<Long, Integer> topFreq = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                currentRowSum += grid[i][j];
                topFreq.merge((long) grid[i][j], 1, Integer::sum);
            }

            long botSum = totalSum - currentRowSum;
            if (currentRowSum == botSum) return true;

            long diff = currentRowSum - botSum;

            if (diff > 0) {
                // TOP se hatao — need = diff
                long need = diff;
                int topRows = i + 1;
                if (topRows > 1 && m > 1) {
                    // Multi x Multi → koi bhi cell hatao
                    if (topFreq.getOrDefault(need, 0) > 0) return true;
                } else if (topRows == 1 && m > 1) {
                    // Single row → sirf left/right endpoint
                    if (grid[0][0] == need || grid[0][m - 1] == need) return true;
                } else if (m == 1 && topRows > 1) {
                    // Single col → sirf top/bottom endpoint
                    if (grid[0][0] == need || grid[i][0] == need) return true;
                }
            } else {
                // BOTTOM se hatao — need = -diff
                long need = -diff;
                int botRows = n - i - 1;
                if (botRows > 1 && m > 1) {
                    // Multi x Multi → freq check (total - top)
                    int cnt = totalFreq.getOrDefault(need, 0) - topFreq.getOrDefault(need, 0);
                    if (cnt > 0) return true;
                } else if (botRows == 1 && m > 1) {
                    // Single row → last row ke endpoints
                    if (grid[n - 1][0] == need || grid[n - 1][m - 1] == need) return true;
                } else if (m == 1 && botRows > 1) {
                    // Single col → top/bottom of bottom section
                    if (grid[i + 1][0] == need || grid[n - 1][0] == need) return true;
                }
            }
        }

        // ============ VERTICAL CUT ============
        long currentColSum = 0;
        HashMap<Long, Integer> leftFreq = new HashMap<>();

        for (int j = 0; j < m - 1; j++) {
            for (int i = 0; i < n; i++) {
                currentColSum += grid[i][j];
                leftFreq.merge((long) grid[i][j], 1, Integer::sum);
            }

            long rightSum = totalSum - currentColSum;
            if (currentColSum == rightSum) return true;

            long diff = currentColSum - rightSum;

            if (diff > 0) {
                // LEFT se hatao
                long need = diff;
                int leftCols = j + 1;
                if (n > 1 && leftCols > 1) {
                    if (leftFreq.getOrDefault(need, 0) > 0) return true;
                } else if (leftCols == 1 && n > 1) {
                    // Single col → top/bottom endpoint
                    if (grid[0][0] == need || grid[n - 1][0] == need) return true;
                } else if (n == 1 && leftCols > 1) {
                    // Single row → left/right endpoint
                    if (grid[0][0] == need || grid[0][j] == need) return true;
                }
            } else {
                // RIGHT se hatao
                long need = -diff;
                int rightCols = m - j - 1;
                if (n > 1 && rightCols > 1) {
                    int cnt = totalFreq.getOrDefault(need, 0) - leftFreq.getOrDefault(need, 0);
                    if (cnt > 0) return true;
                } else if (rightCols == 1 && n > 1) {
                    // Single col → last col ke top/bottom
                    if (grid[0][m - 1] == need || grid[n - 1][m - 1] == need) return true;
                } else if (n == 1 && rightCols > 1) {
                    // Single row → left/right endpoint of right section
                    if (grid[0][j + 1] == need || grid[0][m - 1] == need) return true;
                }
            }
        }

        return false;
    }
}
