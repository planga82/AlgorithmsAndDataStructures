package org.alg.search;

import org.junit.Test;
import org.utils.ArrayUtils;


public class PatternMatchingTest
{
    @Test
    public void test1(){
       char[] text = "THIS IS A TEST TEXT".toCharArray();
       char[] pattern = "TEST".toCharArray();
       PatternMatching.naiveSearch(text, pattern);
    }

    @Test
    public void test2(){
        char[] text = "AABAACAADAABAABA".toCharArray();
        char[] pattern = "AABA".toCharArray();
        PatternMatching.naiveSearch(text, pattern);
    }

    @Test
    public void test3(){
        char[] pattern = "AAAA".toCharArray();
        ArrayUtils.printArray(PatternMatching.lpsFill(pattern));
    }

    @Test
    public void test4(){
        char[] pattern = "ABCDE".toCharArray();
        ArrayUtils.printArray(PatternMatching.lpsFill(pattern));
    }
    @Test
    public void test5(){
        char[] pattern = "AABAACAABAA".toCharArray();
        ArrayUtils.printArray(PatternMatching.lpsFill(pattern));
    }

    @Test
    public void test6(){
        char[] pattern = "AAACAAAAAC".toCharArray();
        ArrayUtils.printArray(PatternMatching.lpsFill(pattern));
    }

    @Test
    public void test7(){
        char[] pattern = "AAABAAA".toCharArray();
        ArrayUtils.printArray(PatternMatching.lpsFill(pattern));
    }

    @Test
    public void test8(){
        char[] text = "THIS IS A TEST TEXT".toCharArray();
        char[] pattern = "TEST".toCharArray();
        PatternMatching.kmpSearch(text, pattern);
    }

    @Test
    public void test9(){
        char[] text = "AABAACAADAABAABA".toCharArray();
        char[] pattern = "AABA".toCharArray();
        PatternMatching.kmpSearch(text, pattern);
    }

    @Test
    public void test10(){
        char[] text = "THIS IS A TEST TEXT".toCharArray();
        char[] pattern = "TEST".toCharArray();
        PatternMatching.rabinKalpSearch(text, pattern,101);
    }

    @Test
    public void test11(){
        char[] text = "AABAACAADAABAABA".toCharArray();
        char[] pattern = "AABA".toCharArray();
        PatternMatching.rabinKalpSearch(text, pattern,101);
    }



}
