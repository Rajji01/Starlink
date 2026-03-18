package com.starlink.backend.dsa.prefixSum;


import java.util.Arrays;

class CountSubmatrices {
    public int countSubmatrices(int[][] grid, int k) {
        int rowSum[]= new int[grid.length];
        int colSum[]= new int[grid[0].length];
        boolean colFlag[]= new boolean[grid[0].length];
        Arrays.fill(colFlag,true);
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            int prev=0;
            for(int j=0;j<grid[0].length;j++){


                colSum[j]+=grid[i][j];
                prev+=colSum[j];
                if(prev<=k){
                    cnt++;
                }
                else{
                    break;
                }
            }


        }

        return cnt;
    }
}
