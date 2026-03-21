package com.starlink.backend.dsa.twopointer;
//https://leetcode.com/problems/flip-square-submatrix-vertically/?envType=daily-question&envId=2026-03-21
public class FlipSquareSubmatrix {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        // 1 2 3 4
        // 1 2 3 4
        // 1 2 3 4
        // 1 2 3 4
        int i=x;
        int j=x+(k-1);
        while(i<j){
            for(int col=y;col<=y+(k-1);col++){
                // System.out.println("i="+i+" j="+j+" col="+col+" col +(k-1)"+(col+k-1));
                int temp=grid[i][col];
                grid[i][col]=grid[j][col];
                grid[j][col]=temp;
            }
            i++;
            j--;
        }
        return grid;
    }
}