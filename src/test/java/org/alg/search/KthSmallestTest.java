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


}
