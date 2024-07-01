/**
 * Improvements of IntList
 * Improvement#1- Rebranding and Culling : IntList -> IntNode
 * Node Structure ?
 * */

public class IntNode {
    public int item;
    public IntNode next;

    public IntNode(int i, IntNode n ) {
        item = i;
        next = n;
    }
}
