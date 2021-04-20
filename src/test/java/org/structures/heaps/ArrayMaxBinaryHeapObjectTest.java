package org.structures.heaps;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.utils.ArrayUtils.printArray;

public class ArrayMaxBinaryHeapObjectTest
{
    @Test
    public void test1(){
        Integer[] arr = {5, 9, 8, 3, 6, 1, 2, 3, 4, 5, 5, 3, 2, 2};
        ArrayMaxBinaryHeapObjects heap = new ArrayMaxBinaryHeapObjects(30);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }

        testStructure(heap);
    }

    @Test
    public void test2(){
        Integer[] arr = {5, 9, 8, 3, 6, 1, 2, 3, 4, 5, 5, 3, 2, 2};
        ArrayMaxBinaryHeapObjects heap = new ArrayMaxBinaryHeapObjects(30);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }

        printArray(heap.arr);
        heap.delete(3);
        printArray(heap.arr);
        testStructure(heap);
        heap.delete(6);
        printArray(heap.arr);
        testStructure(heap);
        heap.delete(0);
        printArray(heap.arr);
        testStructure(heap);
        heap.delete(heap.size-1);
        printArray(heap.arr);
        testStructure(heap);

    }

    @Test
    public void test3(){
        Integer[] arr = {5, 9, 8, 3, 6, 1, 2, 3, 4, 5, 5, 3, 2, 2};
        ArrayMaxBinaryHeapObjects heap = new ArrayMaxBinaryHeapObjects(30);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }

        printArray(heap.arr);
        heap.replaceRoot(0);
        printArray(heap.arr);
        testStructure(heap);

    }

    private void testStructure(ArrayMaxBinaryHeapObjects heap){
        int size = heap.size;
        for (int i = 1; i < size; i++) {
            assertTrue(heap.arr[i].compareTo(heap.arr[heap.getParent(i)]) <= 0);
            if(heap.getLeftChild(i) < size){
                assertTrue(heap.arr[i].compareTo(heap.arr[heap.getLeftChild(i)]) >= 0);
            }
            if(heap.getRightChild(i) < size){
                assertTrue(heap.arr[i].compareTo(heap.arr[heap.getRightChild(i)]) >= 0);
            }
        }
    }
}
