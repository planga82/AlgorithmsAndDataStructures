package alg.search;

import org.alg.search.BinarySearch;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class BinarySearchTest
{
    @Test
    public void test1(){
        int[] arr = {1,2,3};
        assertTrue(BinarySearch.search(arr,2) == 1);
    }

    @Test
    public void test2(){
        int[] arr = {1,2,3};
        assertTrue(BinarySearch.search(arr,1) == 0);
    }

    @Test
    public void test3(){
        int[] arr = {1,2,3};
        assertTrue(BinarySearch.search(arr,3) == 2);
    }

    @Test
    public void test4(){
        int[] arr = {1,2,3};
        assertTrue(BinarySearch.search(arr,6) == -1);
    }

    @Test
    public void test5(){
        int[] arr = {1,2,3,4};
        assertTrue(BinarySearch.search(arr,3) == 2);
    }

    @Test
    public void test6(){
        int[] arr = {1,2,3,4,7};
        assertTrue(BinarySearch.search(arr,5) == -1);
    }
}
