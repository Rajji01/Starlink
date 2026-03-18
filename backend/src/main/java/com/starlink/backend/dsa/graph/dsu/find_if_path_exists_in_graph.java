//package com.starlink.backend.dsa.graph.dsu;
//
//public class find_if_path_exists_in_graph {
//
//
//public boolean validPath(int n, int[][] edges, int source, int destination) {
//    DSU dsu = new DSU(n);
//    for(int edge[]:edges){
//        dsu.unionByRank(edge[0],edge[1]);
//    }
//    return dsu.findParent(source)==dsu.findParent(destination);
//}
//
//}
//class DSU{
//    int parent[];
//    int rank[];
//    DSU(int n){
//        parent= new int[n];
//        rank= new int [n];
//        for(int i=0;i<n;i++){
//            parent[i]=i;
//        }
//    }
//    public int findParent(int node){
//        if(parent[node]==node) return node;
//        return parent[node]=findParent(parent[node]);
//    }
//    public void unionByRank(int node1, int node2){
//        int parent1=findParent(node1);
//        int parent2=findParent(node2);
//
//        if(parent1==parent2) return ;
//        int rank1=rank[parent1];
//        int rank2=rank[parent2];
//        if(rank1<rank2){
//            parent[parent1]=parent2;
//        }
//        else if(rank1>rank2){
//            parent[parent2]=parent1;
//        }
//        else{
//            rank[parent1]++;
//            parent[parent2]=parent1;
//        }
//    }
//}
