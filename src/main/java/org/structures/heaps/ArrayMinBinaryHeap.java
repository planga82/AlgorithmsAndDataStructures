package org.structures.heaps;

import org.utils.ArrayUtils;

public class ArrayMinBinaryHeap {
    int capacity;
    int arr[];
    int size = 0;

    public ArrayMinBinaryHeap(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
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
    public int getMini(){
        return arr[0];
    }

    /**
     * O(Logn)
     * Insert the element
     * @param k
     */
    public void insert(int k){
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
    public int extractMin(){
        int r = getMini();
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
        else if(arr[l] < arr[r]) w = l;
        else w = r;

        if(arr[k] > arr[w]){
            ArrayUtils.swap(arr,k,w);
            reorderDown(w);
        }
    }

    private void reorderUp(int k){
        if(k == 0) return;
        int parent = getParent(k);
        if(arr[parent] > arr[k]){
            ArrayUtils.swap(arr,parent, k);
            reorderUp(parent);
        }
    }


}
