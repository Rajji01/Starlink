//package com.starlink.backend.dsa.graph.dsu;
//
//public class NumberOfIslands {
//
//    public int numIslands(char[][] grid) {
//        int n=grid.length*grid[0].length;
//        DSU dsu= new DSU(grid.length*grid[0].length);
//        int numberOfCol=grid[0].length;
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                if(grid[i][j]=='1'){
//                    if(i-1>=0&&grid[i-1][j]=='1'){
//                        dsu.unionByRank(numberOfCol*i+j,numberOfCol*(i-1)+j);
//                    }
//                    if(i+1<grid.length&&grid[i+1][j]=='1'){
//                        dsu.unionByRank(numberOfCol*i+j,numberOfCol*(i+1)+j);
//                    }
//                    if(j+1<grid[0].length&&grid[i][j+1]=='1'){
//                        dsu.unionByRank(numberOfCol*i+j,numberOfCol*(i)+(j+1));
//                    }
//                    if(j-1>=0&&grid[i][j-1]=='1'){
//                        dsu.unionByRank(numberOfCol*i+j,numberOfCol*(i)+(j-1));
//                    }
//                }
//            }
//        }
//        int cnt = 0;
//        for(int i = 0; i < grid.length; i++) {
//            for(int j = 0; j < grid[0].length; j++) {
//                int idx = i * numberOfCol + j;
//                if(grid[i][j] == '1' && dsu.findParent(idx) == idx) {
//                    cnt++;
//                }
//            }
//        }
//        return cnt;
//    }
//}
//
////
////class DSU{
////    int parent[];
////    int rank[];
////    DSU(int n){
////        parent=new int[n];
////        rank= new int[n];
////        for(int i=0;i<n;i++){
////            parent[i]=i;
////        }
////    }
////    public int findParent(int node){
////        if(parent[node]==node) return node;
////        parent[node]=findParent(parent[node]);
////        return parent[node];
////    }
////    public void unionByRank(int node1, int node2){
////        int parent1=findParent(node1);
////        int parent2=findParent(node2);
////        if(parent1==parent2) return;
////        int rank1=rank[parent1];
////        int rank2=rank[parent2];
////        if(rank[parent1] < rank[parent2]) {
////            parent[parent1] = parent2;  // ✅ Root ko parent banao
////        } else if(rank[parent1] > rank[parent2]) {
////            parent[parent2] = parent1;  // ✅ Root ko parent banao
////        } else {
////            parent[parent2] = parent1;
////            rank[parent1]++;
////        }
////
////    }
////}