package org.structures.nodeBased;

public class UnaryNode<T> {
    T value;
    UnaryNode<T> next;

    public UnaryNode(T value) {
        this.value = value;
    }
}
