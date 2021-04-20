package org.alg.dynamic;

import org.alg.sort.ArrayMergeSort;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class KnapSackTest
{
    @Test
    public void test1(){
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        int res = KnapSack.resolve(W,3,weights,values);
        System.out.println(res);
        assertTrue(res == 220);
    }

    @Test
    public void test2(){
        int[] values = {10, 15, 40};
        int[] weights = {1, 2, 3};
        int W = 6;
        int res = KnapSack.resolve(W,3,weights,values);
        System.out.println(res);
        assertTrue(res == 65);
    }




}
