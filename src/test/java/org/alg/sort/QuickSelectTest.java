package org.alg.sort;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class QuickSelectTest
{
    QuickSelect qs = new QuickSelect();
    @Test
    public void test1(){
        int[] arr = {10,80,30,90,40,50,70};
        //int[] res = {10,30,40,50,70,80,90};
        assertTrue(qs.select(arr,2) == 40);
    }

    @Test
    public void test2(){
        int[] arr = {10,80,30,90,40,50,70};
        //int[] res = {10,30,40,50,70,80,90};
        assertTrue(qs.select(arr,0) == 10);
    }

    @Test
    public void test3(){
        int[] arr = {10,80,30,90,40,50,70};
        //int[] res = {10,30,40,50,70,80,90};
        assertTrue(qs.select(arr,6) == 90);
    }

    @Test
    public void test4(){
        int[] arr = {1,2,3,4,5};
        assertTrue(qs.select(arr,2) == 3);
    }

    @Test
    public void test5(){
        int[] arr = {5,4,3,2,1};
        assertTrue(qs.select(arr,2) == 3);
    }

    @Test
    public void test6(){
        int[] arr = {5,4,3,3,4,2,1};
        //int[] res = {1,2,3,3,4,4,5};
        assertTrue(qs.select(arr,2) == 3);
    }

    @Test
    public void test7(){
        Integer[] arr = {10,80,30,90,40,50,70};
        //int[] res = {10,30,40,50,70,80,90};
        assertTrue(qs.select(arr,2).equals(40));
    }

    @Test
    public void test8(){
        Integer[] arr = {10,80,30,90,40,50,70};
        //int[] res = {10,30,40,50,70,80,90};
        assertTrue(qs.select(arr,0).equals(10));
    }

    @Test
    public void test9(){
        Integer[] arr = {10,80,30,90,40,50,70};
        //int[] res = {10,30,40,50,70,80,90};
        assertTrue(qs.select(arr,6).equals(90));
    }

    @Test
    public void test10(){
        Integer[] arr = {1,2,3,4,5};
        assertTrue(qs.select(arr,2).equals(3));
    }

    @Test
    public void test11(){
        Integer[] arr = {5,4,3,2,1};
        assertTrue(qs.select(arr,2).equals(3));
    }

    @Test
    public void test12(){
        Integer[] arr = {5,4,3,3,4,2,1};
        //int[] res = {1,2,3,3,4,4,5};
        assertTrue(qs.select(arr,2).equals(3));
    }

}
