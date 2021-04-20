package org.structures.stacks;

public class StackArrayInt {

    private int[] data;
    private int top;

    public void initialize(int size){
        data = new int[size];
        top = 0;
    }

    public void push(int element){
        data[top] = element;
        top++;
    }

    public int pop(){
        int ret = data[top];
        top--;
        return ret;
    }

    public int read(){
        return data[top];
    }

}
