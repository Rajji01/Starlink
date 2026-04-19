package com.starlink.backend.dsa.twopointer.maxdistanceBtwPair;

public class Sol {
//    https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/description/?envType=daily-question&envId=2026-04-19
    public int maxDistance(int[] nums1, int[] nums2) {
        int st2=nums2.length-1;
        int st1=nums1.length-1;
        int max=0;
        while(st2>=0&&st1>=0){
            while(st1>st2){st1--;}
            while(st2>=0&&nums2[st2]<nums1[st1]){
                st2--;
            }
            while(st1>st2){st1--;}
            while(st2>=0&&st1>=0&&nums1[st1]<=nums2[st2]){
                max=Math.max(max,Math.abs(st2-st1));
                st1--;
            }
        }
        return max;
    }
}
