package com.starlink.backend.dsa.graph.dsu;

public class smallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU dsu = new DSU();
        for(int i=0;i<s1.length();i++){
            dsu.unionByRank((s1.charAt(i)-'a'),(s2.charAt(i)-'a'));
        }
        StringBuilder sbr= new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            char c=(char)(dsu.findParent(baseStr.charAt(i)-'a')+'a');
            sbr.append(c);

        }
        return sbr.toString();
    }
}

class DSU{
    int parent[];
    int rank[];
    DSU(){
        parent= new int[26];
        rank= new int [26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
    }
    public int findParent(int node){
        if(parent[node]==node) return node;
        return parent[node]=findParent(parent[node]);
    }
    public void unionByRank(int node1, int node2){
        int parent1=findParent(node1);
        int parent2=findParent(node2);

        if(parent1==parent2) return ;

        if(parent1<parent2){
            // rank[parent1]=rank[parent2]+1;
            parent[parent2]=parent1;
        }
        else{
            // rank[parent2]=rank;
            parent[parent1]=parent2;
        }

    }
}

