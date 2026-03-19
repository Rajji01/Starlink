package com.starlink.backend.dsa.prefixSum;

public class CountSubMatricesXY {
//https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/?envType=daily-question&envId=2026-03-19
    public int numberOfSubmatrices(char[][] grid) {
        int colSum[]= new int[grid[0].length];
        boolean flagSum[]= new boolean[grid[0].length];
        int cnt=0;
        //    boolean FlagXPresent=false;
        //    boolean FlagXYPresent=false;
        for(int i=0;i<grid.length;i++){
            int rowSum=0;
            boolean FlagXYPresent=false;
            for(int j=0;j<grid[0].length;j++){
                char ch=grid[i][j];
                if((ch=='X'||ch=='Y'||flagSum[j])){
                    flagSum[j]=true;
                    FlagXYPresent=true;
                }

                int currentSum=( ch=='X' ?1:ch=='Y'?-1:0)+((i>0)?colSum[j]:0);
                colSum[j]=currentSum;

                rowSum+=currentSum;
                // System.out.println("rowSum="+rowSum+" i="+i+" j="+j);
                if(rowSum==0&&(flagSum[j]||FlagXYPresent)){
                    // System.out.println("increment!!!");
                    cnt++;
                }
            }
        }
        return cnt;
    }
}