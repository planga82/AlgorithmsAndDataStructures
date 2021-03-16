package org.alg.search;

import org.alg.sort.ArrayMergeSort;
import org.structures.heaps.ArrayMaxBinaryHeap;
import org.structures.heaps.ArrayMinBinaryHeap;
import org.utils.ArrayUtils;

import java.util.Random;

public class PatternMatching {

    /**
     *
     * Print All the first index where the pattern match in the text
     * O(n) best case
     * O(n*m) worst case
     * @param text
     * @param pattern
     * @return
     */
    public static void naiveSearch(char[] text, char[] pattern){
        for (int i = 0; i < text.length - pattern.length + 1; i++) {
            int k = i;
            for (int j = 0; j < pattern.length; j++) {
                if(text[k] != pattern[j]){
                    break;
                }
                if(j == pattern.length - 1){
                    System.out.println("Item found at: " + i);
                }
                k++;
            }

        }
    }

    /**
     * O(n) worst case
     * @param text
     * @param pattern
     */
    public static void kmpSearch(char[] text, char[] pattern){
        int[] lps = new int[pattern.length];
        int ilps = 0;
        // TODO calculate lps

        for (int i = 0; i < text.length - pattern.length + 1; i++) {
            int k = i;
            for (int j = lps[ilps]; j < pattern.length; j++) {
                if(text[k] != pattern[j]){
                    //No match
                    if(ilps > 0) ilps--;
                    break;
                }
                if(j == pattern.length - 1){
                    //Patter match
                    ilps = pattern.length - 1;
                    System.out.println("Item found at: " + i);
                }
                k++;
            }

        }
    }

    protected static int[] lpsFill(char[] pat){
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        int[] lps = new int[pat.length];
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < pat.length) {
            if (pat[i] == pat[len]) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }

    // d is the number of characters in the input alphabet
    private final static int d = 256;

    /**
     * Avg and best O(n+m)
     * Worst O(n*m)
     * @param text
     * @param pattern
     * @param q
     */
    public static void rabinKalpSearch(char[] text, char[] pattern, int q){
        int h = 1;
        for (int i = 0; i < pattern.length-1; i++) {
            h = (h * d) % q;
        }
        int hashpattern = hash(pattern,0,pattern.length, q);
        int hashtext = hash(text,0,pattern.length,q);
        if(hashpattern == hashtext && compare(text, pattern, 0)){
            System.out.println("Match at position 0");
        }
        for (int i = 1; i < text.length - pattern.length +1 ; i++) {
            hashtext = nextHash(hashtext, pattern.length,text[i-1], text[i+pattern.length -1],q, h);
            if(hashpattern == hashtext && compare(text, pattern, i)){
                System.out.println("Match at position " + (i));
            }
        }
    }

    private static boolean compare(char[] text, char[] pattern, int ini){
        for (int i = 0; i < pattern.length; i++) {
            if(text[ini + i] != pattern[i]){
                return false;
            }
        }
        return true;
    }

    private static int hash(char[] text, int low, int high, int q){
        int hash = 0;
        for (int i = low; i < high; i++) {
            hash = (d*hash + text[i])%q;
        }
        return hash;
    }


    private static int nextHash(int oldHash, int patLen, char out, char in, int q, int h){
        int res = ((oldHash - (out * h))*d + in)%q;
        if(res < 0){
            res = res + q;
        }
        return res;
    }
}
