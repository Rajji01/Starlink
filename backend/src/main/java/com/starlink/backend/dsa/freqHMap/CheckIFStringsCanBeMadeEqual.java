package com.starlink.backend.dsa.freqHMap;

public class CheckIFStringsCanBeMadeEqual {
//https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/description/?envType=daily-question&envId=2026-03-30
    public boolean checkStrings(String s1, String s2) {
        int[] evenFreq = new int[26];
        int[] oddFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                evenFreq[s1.charAt(i) - 'a']++;
                evenFreq[s2.charAt(i) - 'a']--;
            } else {
                oddFreq[s1.charAt(i) - 'a']++;
                oddFreq[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (evenFreq[i] != 0 || oddFreq[i] != 0) return false;
        }

        return true;
    }
}