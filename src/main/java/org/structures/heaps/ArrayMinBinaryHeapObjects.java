package org.structures.heaps;

import org.utils.ArrayUtils;

public class ArrayMinBinaryHeapObjects {
    int capacity;
    Comparable arr[];
    int size = 0;

    public ArrayMinBinaryHeapObjects(int capacity){
        this.capacity = capacity;
        arr = new Comparable[capacity];
    }

    protected int getParent(int i){
        return (i-1)/2;
    }

    protected int getLeftChild(int i){
        return (2*i)+1;
    }

    protected int getRightChild(int i){
        return (2*i)+2;
    }


    /**
     * O(1)
     * @return the min element
     */
    public Comparable getMini(){
        return arr[0];
    }

    /**
     * O(Logn)
     * Insert the element
     * @param k
     */
    public void insert(Comparable k){
        int pos = size;
        size++;
        arr[pos] = k;
        reorderUp(pos);
    }

    /**
     * O(log n)
     * Extract the min element
     * @return
     */
    public Comparable extractMin(){
        Comparable r = getMini();
        delete(0);
        return r;
    }


    /**
     * @param k Position in the array of the element to delete
     */
    protected void delete(int k){
        if(k<0 || k > size - 1) throw new ArrayIndexOutOfBoundsException("Index out of the range");
        if(k == size-1){
            arr[size-1] = 0;
            size--;
            return;
        }
        ArrayUtils.swap(arr,size-1, k);
        arr[size-1] = 0;
        size--;
        reorderUp(k);
        reorderDown(k);

    }

    private void reorderDown(int k){
        if(k >= size-1) return;

        int l = getLeftChild(k);
        int r = getRightChild(k);
        if(l > size-1 && r > size-1) return;

        int w;
        if(l > size-1) w = r;
        else if(r > size-1) w = l;
        else if(arr[l].compareTo(arr[r]) < 0) w = l;
        else w = r;

        if(arr[k].compareTo(arr[w]) > 0){
            ArrayUtils.swap(arr,k,w);
            reorderDown(w);
        }
    }

    private void reorderUp(int k){
        if(k == 0) return;
        int parent = getParent(k);
        if(arr[parent].compareTo(arr[k]) > 0){
            ArrayUtils.swap(arr,parent, k);
            reorderUp(parent);
        }
    }


}
