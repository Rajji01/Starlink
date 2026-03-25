package com.starlink.backend.dsa.prefixSum.equalSumGridPartiton;
//https://leetcode.com/problems/equal-sum-grid-partition-i/submissions/1958348838/?envType=daily-question&envId=2026-03-25
public class EqualSumGridPartition {

    public boolean canPartitionGrid(int[][] grid) {
        long prefix[]= new long[grid.length];
        long suffix[]= new long[grid.length];
        long rowLevSumPr=0;
        long rowLevSumsf=0;
        long prefixC[]= new long[grid[0].length];
        long suffixC[]= new long[grid[0].length];
        long colLevSumPr=0;
        long colLevSumsf=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=n-1;i>=0;i--){
            suffix[i]= rowLevSumsf;
            for(int j=m-1;j>=0;j--){
                rowLevSumsf+=grid[i][j];
            }

        }
        for(int i=0;i<grid.length;i++){

            for(int j=0;j<grid[0].length;j++){
                rowLevSumPr+=grid[i][j];
            }
            prefix[i]= rowLevSumPr;
            if(prefix[i]==suffix[i]) return true;
        }

        for(int j=m-1;j>=0;j--){
            suffixC[j]=colLevSumsf;
            for(int i=0;i<n;i++){
                colLevSumsf+=grid[i][j];
            }
            // System.out.println("j="+colLevSumsf);
        }
        for(int j=0;j<m;j++){

            for(int i=0;i<n;i++){
                colLevSumPr+=grid[i][j];
            }
            prefixC[j]=colLevSumPr;
            // System.out.println("!!!!!j="+colLevSumPr);
            if(prefixC[j]==suffixC[j])return true;
        }


        return false;

    }
}