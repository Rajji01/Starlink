package com.starlink.backend.dsa.matrix.decodeCiphertext;

class Solution {
//    https://leetcode.com/problems/decode-the-slanted-ciphertext/description/?envType=daily-question&envId=2026-04-04
    public String decodeCiphertext(String encodedText, int rows) {
        int totLen=encodedText.length();
        int col=totLen/rows;
        char ar[][]= new char[rows][col];
        int r=-1;
        int c=0;
        for(int i=0;i<encodedText.length();i++){
            if(i%col==0){
                r++;
            }
            char cur=encodedText.charAt(i);
            ar[r][i%col]=cur;
        }
        // for(int i=0;i<rows;i++){
        //        StringBuilder s= new StringBuilder();
        //     for(int j=0;j<col;j++){
        //      s.append(ar[i][j]);
        //     }
        //     System.out.println(s);
        // }
        StringBuilder sbr= new StringBuilder();
        for(int j=0;j<col;j++){
            int row=0;
            int cCol=j;
            int cnt=0;

            while(row<rows&&cCol<col){
                sbr.append(ar[row][cCol]);
                //       char ch = ar[row][cCol];

                // if(!(row == rows-1 && ch == ' ')) {
                //     sbr.append(ch);
                // }
                row+=1;
                cCol+=1;
                cnt++;

            }
            // while(cnt)
        }
        // Bas end se trailing spaces hatao!
        while(sbr.length() > 0 &&
                sbr.charAt(sbr.length()-1) == ' '){
            sbr.deleteCharAt(sbr.length()-1);
        }

        return sbr.toString();
        // return sbr.toString();
    }
}