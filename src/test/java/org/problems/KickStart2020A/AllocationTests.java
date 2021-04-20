package org.problems.KickStart2020A;

import org.junit.Test;
import org.structures.heaps.ArrayMaxBinaryHeap;

import static org.junit.Assert.assertTrue;
import static org.utils.ArrayUtils.printArray;

public class AllocationTests
{
    @Test
    public void test1(){
        int[] arr = {30,30,10,10};
        System.out.println(Allocation.getResult(arr,100));
    }



}
