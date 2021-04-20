package org.alg.sort;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class SelectionSortTest
{
    SelectionSort ss = new SelectionSort();
    @Test
    public void test1(){
        int[] arr = {10,80,30,90,40,50,70};
        ss.order(arr);
        int[] res = {10,30,40,50,70,80,90};
        assertEqualArr(arr, res);
    }

    @Test
    public void test2(){
        int[] arr = {1,2,3,4,5};
        ss.order(arr);
        int[] res = {1,2,3,4,5};
        assertEqualArr(arr, res);
    }

    @Test
    public void test3(){
        int[] arr = {5,4,3,2,1};
        ss.order(arr);
        int[] res = {1,2,3,4,5};
        assertEqualArr(arr, res);
    }

    @Test
    public void test4(){
        int[] arr = {5,4,3,3,4,2,1};
        ss.order(arr);
        int[] res = {1,2,3,3,4,4,5};
        assertEqualArr(arr, res);
    }

    @Test
    public void test5(){
        Integer[] arr = {10,80,30,90,40,50,70};
        ss.order(arr);
        Integer[] res = {10,30,40,50,70,80,90};
        assertEqualArr(arr, res);
    }

    @Test
    public void test6(){
        Integer[] arr = {1,2,3,4,5};
        ss.order(arr);
        Integer[] res = {1,2,3,4,5};
        assertEqualArr(arr, res);
    }

    @Test
    public void test7(){
        Integer[] arr = {5,4,3,2,1};
        ss.order(arr);
        Integer[] res = {1,2,3,4,5};
        assertEqualArr(arr, res);
    }

    @Test
    public void test8(){
        Integer[] arr = {5,4,3,3,4,2,1};
        ss.order(arr);
        Integer[] res = {1,2,3,3,4,4,5};
        assertEqualArr(arr, res);
    }

    private void assertEqualArr(int[] arr1, int[] arr2){
        for (int i =0; i<arr1.length;i++) {
            assertTrue(arr1[i] == arr2[i]);
        }
    }

    private void assertEqualArr(Comparable[] arr1, Comparable[] arr2){
        for (int i =0; i<arr1.length;i++) {
            assertTrue(arr1[i].equals(arr2[i]));
        }
    }


}
