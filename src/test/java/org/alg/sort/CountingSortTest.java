package org.alg.sort;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class CountingSortTest
{
    CountingSort cs = new CountingSort();
    @Test
    public void test1(){
        int[] arr = {10,80,30,90,40,50,70};
        int[] ret = cs.order(arr,100);
        int[] res = {10,30,40,50,70,80,90};
        assertEqualArr(ret, res);
    }

    @Test
    public void test2(){
        int[] arr = {1,2,3,4,5};
        int[] ret = cs.order(arr,10);
        int[] res = {1,2,3,4,5};
        assertEqualArr(ret, res);
    }

    @Test
    public void test3(){
        int[] arr = {5,4,3,2,1};
        int[] ret = cs.order(arr,10);
        int[] res = {1,2,3,4,5};
        assertEqualArr(ret, res);
    }

    @Test
    public void test4(){
        int[] arr = {5,4,3,3,4,2,1};
        int[] ret = cs.order(arr,100);
        int[] res = {1,2,3,3,4,4,5};
        assertEqualArr(ret, res);
    }

    private void assertEqualArr(int[] arr1, int[] arr2){
        for (int i =0; i<arr1.length;i++) {
            assertTrue(arr1[i] == arr2[i]);
        }
    }
}
