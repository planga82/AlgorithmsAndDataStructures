package org.structures.nodeBased;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest
{

    @Before
    public void initialize(){

    }

    @Test
    public void test1(){
        Integer[] data = {1,5,9,2,6,3,7,4,8};
        Integer[] ordered = {1,2,3,4,5,6,7,8,9};
        BinarySearchTree structure = new BinarySearchTree();

        for (int i = 0; i < data.length; i++) {
            structure.insert(data[i]);

        }
        compareArrays(ordered, structure.traverse());
        assertTrue(structure.getSize() == 9);
    }

    @Test
    public void test2(){
        Integer[] data = {1,5,9,2,6,3,7,4,8};
        Integer[] ordered = {1,3,4,7};
        Integer[] toDel = {6,9,2,5,8};
        BinarySearchTree structure = new BinarySearchTree();

        for (int i = 0; i < data.length; i++) {
            structure.insert(data[i]);
        }
        for (int i = 0; i < toDel.length; i++) {
            structure.delete(toDel[i]);
        }

        compareArrays(ordered, structure.traverse());
        assertTrue(structure.getSize() == 4);
    }

    @Test
    public void test3(){
        Integer[] data = {1,5,9,2,6,3,7,4,8};
        BinarySearchTree structure = new BinarySearchTree();

        for (int i = 0; i < data.length; i++) {
            structure.insert(data[i]);
        }

        assertTrue(structure.search(5).equals(new Integer(5)));
        assertTrue(structure.search(10) == null);
    }

    private void compareArrays(Comparable[] arr1, Comparable[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            assertTrue(arr1[i].equals(arr2[i]));
        }
    }

}
