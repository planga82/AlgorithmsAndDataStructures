package org.alg.search;

import org.alg.search.KthSmallest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KthSmallestTest
{
    @Test
    public void test1(){
        int[] arr = {7, 10, 4, 3, 20, 15};
        assert(KthSmallest.simple(arr,3) == 7);
    }

    @Test
    public void test2(){
        int[] arr = {7, 10, 4, 3, 20, 15};
        assertTrue(KthSmallest.simple(arr,4) == 10);
    }

    @Test
    public void test3(){
        int[] arr = {7, 10, 4, 3, 20, 15};
        assert(KthSmallest.extractWithMinHeap(arr,3) == 7);
    }

    @Test
    public void test4(){
        int[] arr = {7, 10, 4, 3, 20, 15};
        assertTrue(KthSmallest.extractWithMinHeap(arr,4) == 10);
    }

    @Test
    public void test5(){
        int[] arr = {7, 10, 4, 3, 20, 15};
        assert(KthSmallest.extractWithMaxHeap(arr,3) == 7);
    }

    @Test
    public void test6(){
        int[] arr = {7, 10, 4, 3, 20, 15};
        assertTrue(KthSmallest.extractWithMaxHeap(arr,4) == 10);
    }

    @Test
    public void test7(){
        int[] arr = {7, 10, 4, 3, 20, 15};
        int res = KthSmallest.quickSelect(arr,3);
        System.out.println(res);
        assert(res == 7);
    }

    @Test
    public void test8(){
        int[] arr = {7, 10, 4, 3, 20, 15};
        assertTrue(KthSmallest.quickSelect(arr,4) == 10);
    }

    @Test
    public void test9(){
        int[] arr = {7, 10, 4, 3, 20, 15};
        int res = KthSmallest.randomizedQuickSelect(arr,3);
        System.out.println(res);
        assert(res == 7);
    }

    @Test
    public void test10(){
        int[] arr = {7, 10, 4, 3, 20, 15};
        assertTrue(KthSmallest.randomizedQuickSelect(arr,4) == 10);
    }


}
