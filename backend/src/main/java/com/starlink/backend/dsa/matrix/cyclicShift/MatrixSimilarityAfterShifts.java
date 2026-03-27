package com.starlink.backend.dsa.matrix.cyclicShift;

public class MatrixSimilarityAfterShifts {
//    https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/?envType=daily-question&envId=2026-03-27
    public boolean areSimilar(int[][] mat, int k) {
        int colLen=mat[0].length;
        if(k%(colLen)==0) return true;
        k=k%colLen;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if( i%2==0 && mat[i][j] != mat[i][(j+k)%colLen] ) return false;
                else if( i%2!=0 && mat[i][j] != mat[i][ (j-k+colLen) % colLen] ) return false;
            }
        }
        return true;
    }
}