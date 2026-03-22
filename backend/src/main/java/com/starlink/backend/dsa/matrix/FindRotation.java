package com.starlink.backend.dsa.matrix;

public class FindRotation {
//    https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/?envType=daily-question&envId=2026-03-22
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        // 4 possible rotations
        boolean r0 = true;  // 0°
        boolean r90 = true; // 90°
        boolean r180 = true; // 180°
        boolean r270 = true; // 270°

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 0°: mat[i][j] should equal target[i][j]
                if(mat[i][j] != target[i][j]) r0 = false;

                // 90°: mat[i][j] should equal target[j][n-1-i]
                if(mat[i][j] != target[j][n-1-i]) r90 = false;

                // 180°: mat[i][j] should equal target[n-1-i][n-1-j]
                if(mat[i][j] != target[n-1-i][n-1-j]) r180 = false;

                // 270°: mat[i][j] should equal target[n-1-j][i]
                if(mat[i][j] != target[n-1-j][i]) r270 = false;
            }
        }

        return r0 || r90 || r180 || r270;
    }
}