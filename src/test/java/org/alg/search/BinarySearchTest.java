package org.alg.search;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BinarySearchTest
{
    BinarySearch bs = new BinarySearch();
    @Test
    public void test1(){
        int[] arr = {1,2,3};
        assertTrue(bs.search(arr,2) == 1);
    }

    @Test
    public void test2(){
        int[] arr = {1,2,3};
        assertTrue(bs.search(arr,1) == 0);
    }

    @Test
    public void test3(){
        int[] arr = {1,2,3};
        assertTrue(bs.search(arr,3) == 2);
    }

    @Test
    public void test4(){
        int[] arr = {1,2,3};
        assertTrue(bs.search(arr,6) == -1);
    }

    @Test
    public void test5(){
        int[] arr = {1,2,3,4};
        assertTrue(bs.search(arr,3) == 2);
    }

    @Test
    public void test6(){
        int[] arr = {1,2,3,4,7};
        assertTrue(bs.search(arr,5) == -1);
    }

    @Test
    public void test7(){
        Integer[] arr = {1,2,3};
        assertTrue(bs.search(arr,2) == 1);
    }

    @Test
    public void test8(){
        Integer[] arr = {1,2,3};
        assertTrue(bs.search(arr,1) == 0);
    }

    @Test
    public void test9(){
        Integer[] arr = {1,2,3};
        assertTrue(bs.search(arr,3) == 2);
    }

    @Test
    public void test10(){
        Integer[] arr = {1,2,3};
        assertTrue(bs.search(arr,6) == -1);
    }

    @Test
    public void test11(){
        Integer[] arr = {1,2,3,4};
        assertTrue(bs.search(arr,3) == 2);
    }

    @Test
    public void test12(){
        Integer[] arr = {1,2,3,4,7};
        assertTrue(bs.search(arr,5) == -1);
    }
}
