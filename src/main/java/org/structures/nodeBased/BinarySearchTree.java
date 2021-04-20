package org.structures.nodeBased;


import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {
    private BinaryNode<Comparable> root;
    private int size = 0;

    /**
     * O(log N)
     * @param element
     * @return
     */
    public Comparable search(Comparable element){
        if(root == null){
            return null;
        }else {
            return searchrec(element, root);
        }
    }

    private Comparable searchrec(Comparable element, BinaryNode<Comparable> current){
        if(current == null){
            return null;
        }else if(current.getValue().equals(element)){
            return current.getValue();
        }else if(current.isLeaf()){
            return null;
        }else if(element.compareTo(current.getValue()) > 0){
            return searchrec(element, current.getRight());
        }else{
            return searchrec(element, current.getLeft());
        }
    }

    /**
     * O(logN)
     * Randomize the input to balance the tree
     * @param element
     */
    public void insert(Comparable element){
        if(root == null){
            root = new BinaryNode<>(element);
        }else{
            insertrec(element, root);
        }
        size++;
    }

    private void insertrec(Comparable element, BinaryNode<Comparable> current){
        if(current.getValue().equals(element)){
            //do nothing
        }else if(element.compareTo(current.getValue()) > 0){
            if(current.getRight() == null){
                current.setRight(new BinaryNode<>(element));
            }else {
                insertrec(element, current.getRight());
            }
        }else{
            if(current.getLeft() == null){
                current.setLeft(new BinaryNode<>(element));
            }else {
                insertrec(element, current.getLeft());
            }
        }
    }

    /**
     * O(log n)
     * @param element
     */
    public void delete(Comparable element){
        if(root == null){
            return;
        }else {
            size = size - deleterec(element, root, null);
        }
    }

    private int deleterec(Comparable element, BinaryNode<Comparable> current, BinaryNode<Comparable> parent){
        if(current.getValue().equals(element)) {
                deleteNode(current, parent);
                return 1;
        }else{
            if(!current.isLeaf()){
                int delRight = 0, delLeft = 0;
                if(current.getLeft() != null && element.compareTo(current.getValue()) < 0){
                    delLeft = deleterec(element, current.getLeft(), current);
                }else if(current.getRight() != null && element.compareTo(current.getValue()) > 0){
                    delRight = deleterec(element, current.getRight(), current);
                }else{
                    return 0;
                }
                return delLeft + delRight;
            }else{
                return 0;
            }
        }
    }

    private void deleteNode(BinaryNode<Comparable> current, BinaryNode<Comparable> parent){
        BinaryNode<Comparable> newNode;
        if(current.isLeaf()) {
            newNode = null;
            reasignparent(current,parent,newNode);
        }else if(current.getRight() == null){
            newNode = current.getLeft();
            reasignparent(current,parent,newNode);
        }else if(current.getLeft() == null){
            newNode = current.getRight();
            reasignparent(current,parent,newNode);
        }else{
            newNode = getDisconectedSuccesorNode(current.getRight(),current);
            reasignparent(current,parent,newNode);
            newNode.setLeft(current.getLeft());
            newNode.setRight(current.getRight());
        }
    }

    private void reasignparent(BinaryNode<Comparable> current, BinaryNode<Comparable> parent, BinaryNode<Comparable> newNode){
        if(parent == null){
            root = newNode;
        }else {
            if (parent.getLeft() != null && parent.getLeft().equals(current)) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
        }
    }

    private BinaryNode<Comparable> getDisconectedSuccesorNode(BinaryNode<Comparable> node, BinaryNode<Comparable> parent){
        if(node.getLeft() == null){
               if(node.getRight() == null){
                   reasignparent(node, parent, null);
               }else{
                   reasignparent(node, parent, node.getRight());
               }
               return node;
        }else{
            return getDisconectedSuccesorNode(node.getLeft(), node);
        }
    }

    /**
     * O(n)
     * @return
     */
    public Comparable[] traverse(){
        List<Comparable> result = new LinkedList<>();
        traverserec(root, result);
        Comparable[] res = new Comparable[size];
        return result.toArray(res);
    }

    private void traverserec(BinaryNode<Comparable> current, List<Comparable> result){
        if(current.getLeft() != null){
            traverserec(current.getLeft(), result);
        }
        result.add(current.getValue());
        if(current.getRight() != null){
            traverserec(current.getRight(), result);
        }
    }

    public int getSize(){
        return size;
    }
}
